package io.github.yibird.starter.extension.datapermission.mp.handler;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.extension.plugins.handler.DataPermissionHandler;
import io.github.yibird.starter.core.constant.StringConstants;
import io.github.yibird.starter.core.enums.DataSourceType;
import io.github.yibird.starter.core.utils.DataSourceUtils;
import io.github.yibird.starter.extension.datapermission.core.annotation.DataPermission;
import io.github.yibird.starter.extension.datapermission.core.enums.DataScope;
import io.github.yibird.starter.extension.datapermission.core.model.RoleContext;
import io.github.yibird.starter.extension.datapermission.core.model.UserContext;
import io.github.yibird.starter.extension.datapermission.core.store.DataPermissionUserContextProvider;
import io.micrometer.common.util.StringUtils;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.ParenthesedExpressionList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.ParenthesedSelect;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;

/**
 * @Description mybatisPlus 数据权限默认实现
 * @Author zchengfeng
 * @Datetime 2025/4/29 09:40
 */
public class DefaultDataPermissionHandler implements DataPermissionHandler {

    private static final Logger log = LoggerFactory.getLogger(DefaultDataPermissionHandler.class);
    private static final DataSource dataSource = SpringUtil.getBean(DataSource.class);
    private final DataPermissionUserContextProvider dataPermissionUserContextProvider;

    public DefaultDataPermissionHandler(DataPermissionUserContextProvider dataPermissionUserContextProvider) {
        this.dataPermissionUserContextProvider = dataPermissionUserContextProvider;
    }

    @Override
    public Expression getSqlSegment(Expression where, String mappedStatementId) {
        try {
            Class<?> clazz = Class.forName(mappedStatementId.substring(0, mappedStatementId
                    .lastIndexOf(StringConstants.DOT)));
            // 获取方法名称
            String methodName = mappedStatementId.substring(mappedStatementId.lastIndexOf(StringConstants.DOT) + 1);
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                // 获取方法上的数据权限注解
                DataPermission dataPermission = method.getAnnotation(DataPermission.class);
                // 获取方法名
                String name = method.getName();
                // 如果方法上不存在DataPermission注解 或
                if (dataPermission == null || !CharSequenceUtil.equalsAny(methodName, name, name + "_COUNT")) {
                    continue;
                }
                if (dataPermissionUserContextProvider.isFilter()) {
                    return buildDataScopeFilter(dataPermission, where);
                }
            }
        } catch (ClassNotFoundException e) {
            log.error("Data permission handler build data scope filter occurred an error: {}.", e.getMessage(), e);
        }
        return null;
    }

    public Expression buildDataScopeFilter(DataPermission dataPermission, Expression expression) {
        Expression sqlExpression = null;
        UserContext userContext = dataPermissionUserContextProvider.getUserContext();
        Set<RoleContext> roles = userContext.getRoles();
        for (RoleContext roleContext : roles) {
            DataScope dataScope = roleContext.getDataScope();
            // 如果是所有权限则直接返回sql表达式
            if (DataScope.ALL.equals(dataScope)) {
                return expression;
            }
            switch (dataScope) {
                case DEPT_AND_CHILD ->
                        sqlExpression = this.buildDeptAndChildExpression(dataPermission, userContext, expression);
                case DEPT -> sqlExpression = this.buildDeptExpression(dataPermission, userContext, expression);
                case SELF -> sqlExpression = this.buildSelfExpression(dataPermission, userContext, expression);
                case CUSTOM -> sqlExpression = this.buildCustomExpression(dataPermission, roleContext, expression);
                default -> throw new IllegalArgumentException("暂不支持 [%s] 数据权限".formatted(dataScope));
            }
        }
        return expression != null ? new AndExpression(expression, new ParenthesedExpressionList<>(sqlExpression))
                : sqlExpression;
    }

    public Expression buildDeptAndChildExpression(DataPermission dataPermission, UserContext userContext,
                                                  Expression where) {
        ParenthesedSelect subSelect = new ParenthesedSelect();
        PlainSelect select = new PlainSelect();
        select.setSelectItems(Collections.singletonList(new SelectItem<>(new Column(dataPermission.id()))));
        select.setFromItem(new Table(dataPermission.deptTableAlias()));

        EqualsTo equalsTo = new EqualsTo();
        equalsTo.setLeftExpression(new Column(dataPermission.id()));
        equalsTo.setRightExpression(new LongValue(userContext.getDeptId()));

        // 根据数据源获取数据库类型
        DataSourceType databaseType = DataSourceUtils.getDatabaseType(dataSource);
        if (databaseType == null) {
            throw new IllegalArgumentException("暂不支持 [%s] 数据库".formatted(databaseType));
        }

        Expression inSetExpression;
        switch (databaseType) {
            case DataSourceType.MYSQL:
                Function findInSetFunction = new Function();
                findInSetFunction.setName("find_in_set");
                findInSetFunction.setParameters(new ExpressionList<>(new LongValue(userContext
                        .getDeptId()), new StringValue(new Column("ancestors") + ",")));
                inSetExpression = findInSetFunction;
                break;
            case DataSourceType.POSTGRESQL:
                // 构建 concat 函数
                Function concatFunction = new Function("concat");
                concatFunction.setParameters(new ExpressionList<>(new Column("ancestors"), new StringValue(",")));

                // 创建 LIKE 函数
                LikeExpression likeExpression = new LikeExpression();
                likeExpression.setLeftExpression(concatFunction);
                likeExpression.setRightExpression(new StringValue("%," + userContext.getDeptId() + ",%"));
                inSetExpression = likeExpression;
                break;
            default:
                throw new IllegalArgumentException("暂不支持 [%s] 数据权限".formatted(""));
        }

        select.setWhere(new OrExpression(equalsTo, inSetExpression));
        subSelect.setSelect(select);
        // 构建父查询
        InExpression inExpression = new InExpression();
        inExpression.setLeftExpression(this.buildColumn(dataPermission.tableAlias(), dataPermission.deptId()));
        inExpression.setRightExpression(subSelect);

        return where != null ? new OrExpression(where, inExpression) : inExpression;
    }

    /**
     * 构建本部门数据权限表达式
     *
     * @param dataPermission 数据权限注解
     * @param userContext    用户上下文
     * @param expression     原表达式
     * @return Expression
     */
    public Expression buildDeptExpression(DataPermission dataPermission, UserContext userContext,
                                          Expression expression) {
        // 创建一个 EqualsTo 表达式对象,EqualsTo 是 JSqlParser 中的一个类,代表 SQL 中的等值比较（=）表达式
        EqualsTo equalsTo = new EqualsTo();
        // 设置EqualsTo左侧表达式,左侧是匹配的列条件
        equalsTo.setLeftExpression(this.buildColumn(dataPermission.tableAlias(), dataPermission.deptId()));
        // 设置EqualsTo右侧表达式,右侧通常是匹配值
        equalsTo.setRightExpression(new LongValue(userContext.getDeptId()));
        // 如果expression不为空,则构建OR表达式对象与expression拼接,否则直接返回equalsTo
        return null != expression ? new OrExpression(expression, equalsTo) : equalsTo;
    }

    /**
     * 构建当前用户数据权限表达式
     *
     * @param dataPermission 数据权限注解
     * @param userContext    用户上下文
     * @param expression     表达式
     * @return Expression
     */
    public Expression buildSelfExpression(DataPermission dataPermission, UserContext userContext,
                                          Expression expression) {
        EqualsTo equalsTo = new EqualsTo();
        equalsTo.setLeftExpression(this.buildColumn(dataPermission.tableAlias(), dataPermission.userId()));
        equalsTo.setRightExpression(new LongValue(userContext.getUserId()));
        return null != expression ? new OrExpression(expression, equalsTo) : equalsTo;
    }

    public Expression buildCustomExpression(DataPermission dataPermission, RoleContext roleContext, Expression expression) {

        ParenthesedSelect subSelect = new ParenthesedSelect();
        PlainSelect select = new PlainSelect();
        select.setSelectItems(Collections.singletonList(new SelectItem<>(new Column(dataPermission.deptId()))));
        select.setFromItem(new Table(dataPermission.roleDeptTableAlias()));
        EqualsTo equalsTo = new EqualsTo();
        equalsTo.setLeftExpression(new Column(dataPermission.roleId()));
        equalsTo.setRightExpression(new LongValue(roleContext.getRoleId()));
        select.setWhere(equalsTo);
        subSelect.setSelect(select);

        // 构建父查询
        InExpression inExpression = new InExpression();
        inExpression.setLeftExpression(this.buildColumn(dataPermission.tableAlias(), dataPermission.deptId()));
        inExpression.setRightExpression(subSelect);
        return expression != null ? new OrExpression(expression, inExpression) : inExpression;
    }

    /**
     * 构建列
     *
     * @param tableAlias 表别名
     * @param columnName 列名
     * @return Column实例
     */
    private Column buildColumn(String tableAlias, String columnName) {
        if (StringUtils.isNotEmpty(tableAlias)) {
            return new Column("%s.%s".formatted(tableAlias, columnName));
        }
        return new Column(columnName);
    }
}
