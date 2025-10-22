package io.github.yibird.model.entity;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.TypedProp;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.table.Props;
import org.babyfish.jimmer.sql.ast.table.PropsFor;

@GeneratedBy(
        type = RoleEntity.class
)
@PropsFor(RoleEntity.class)
public interface RoleEntityProps extends Props {
    TypedProp.Scalar<RoleEntity, Long> ID = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("id"));

    TypedProp.Scalar<RoleEntity, String> ROLE_NAME = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("roleName"));

    TypedProp.Scalar<RoleEntity, Integer> DATA_SCOPE = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("dataScope"));

    TypedProp.Scalar<RoleEntity, Integer> DATA_STATUS = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("dataStatus"));

    TypedProp.Scalar<RoleEntity, String> REMARK = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("remark"));

    TypedProp.Scalar<RoleEntity, Long> VERSION = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("version"));

    TypedProp.Scalar<RoleEntity, Integer> SORT = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("sort"));

    TypedProp.Scalar<RoleEntity, Integer> DELETED = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("deleted"));

    TypedProp.Scalar<RoleEntity, Long> UNION_ID = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("unionId"));

    TypedProp.Scalar<RoleEntity, Long> CREATE_BY = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("createBy"));

    TypedProp.Scalar<RoleEntity, LocalDateTime> CREATE_TIME = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("createTime"));

    TypedProp.Scalar<RoleEntity, Long> UPDATE_BY = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("updateBy"));

    TypedProp.Scalar<RoleEntity, LocalDateTime> UPDATE_TIME = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("updateTime"));

    TypedProp.Scalar<RoleEntity, Long> DELETE_BY = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("deleteBy"));

    TypedProp.Scalar<RoleEntity, LocalDateTime> DELETE_TIME = 
        TypedProp.scalar(ImmutableType.get(RoleEntity.class).getProp("deleteTime"));

    PropExpression.Num<Long> id();

    PropExpression.Str roleName();

    PropExpression.Num<Integer> dataScope();

    PropExpression.Num<Integer> dataStatus();

    PropExpression.Str remark();

    PropExpression.Num<Long> version();

    PropExpression.Num<Integer> sort();

    PropExpression.Num<Integer> deleted();

    PropExpression.Num<Long> unionId();

    PropExpression.Num<Long> createBy();

    PropExpression.Tp<LocalDateTime> createTime();

    PropExpression.Num<Long> updateBy();

    PropExpression.Tp<LocalDateTime> updateTime();

    PropExpression.Num<Long> deleteBy();

    PropExpression.Tp<LocalDateTime> deleteTime();
}
