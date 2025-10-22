package io.github.yibird.starter.extension.tenant.mp.handler.inline;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import io.github.yibird.starter.extension.tenant.core.autoconfigure.TenantProperties;
import io.github.yibird.starter.extension.tenant.core.context.TenantContextHolder;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.schema.Column;

import java.util.List;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/28 15:06
 */
public class DefaultTenantLineHandler implements TenantLineHandler {
    private final TenantProperties tenantProperties;

    public DefaultTenantLineHandler(TenantProperties tenantProperties) {
        this.tenantProperties = tenantProperties;
    }

    @Override
    public Expression getTenantId() {
        Long tenantId = TenantContextHolder.getTenantId();
        if (null != tenantId) {
            return new LongValue(tenantId);
        }
        return null;
    }

    @Override
    public String getTenantIdColumn() {
        return TenantLineHandler.super.getTenantIdColumn();
    }

    @Override
    public boolean ignoreTable(String tableName) {
        return TenantLineHandler.super.ignoreTable(tableName);
    }

    @Override
    public boolean ignoreInsert(List<Column> columns, String tenantIdColumn) {
        return TenantLineHandler.super.ignoreInsert(columns, tenantIdColumn);
    }
}
