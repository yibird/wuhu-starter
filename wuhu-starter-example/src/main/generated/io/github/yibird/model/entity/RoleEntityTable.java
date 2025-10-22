package io.github.yibird.model.entity;

import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = RoleEntity.class
)
public class RoleEntityTable extends AbstractTypedTable<RoleEntity> implements RoleEntityProps {
    public static final RoleEntityTable $ = new RoleEntityTable();

    public RoleEntityTable() {
        super(RoleEntity.class);
    }

    public RoleEntityTable(AbstractTypedTable.DelayedOperation<RoleEntity> delayedOperation) {
        super(RoleEntity.class, delayedOperation);
    }

    public RoleEntityTable(TableImplementor<RoleEntity> table) {
        super(table);
    }

    protected RoleEntityTable(RoleEntityTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    @Override
    public PropExpression.Num<Long> id() {
        return __get(RoleEntityProps.ID.unwrap());
    }

    @Override
    public PropExpression.Str roleName() {
        return __get(RoleEntityProps.ROLE_NAME.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> dataScope() {
        return __get(RoleEntityProps.DATA_SCOPE.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> dataStatus() {
        return __get(RoleEntityProps.DATA_STATUS.unwrap());
    }

    @Override
    public PropExpression.Str remark() {
        return __get(RoleEntityProps.REMARK.unwrap());
    }

    @Override
    public PropExpression.Num<Long> version() {
        return __get(RoleEntityProps.VERSION.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> sort() {
        return __get(RoleEntityProps.SORT.unwrap());
    }

    @Override
    public PropExpression.Num<Integer> deleted() {
        return __get(RoleEntityProps.DELETED.unwrap());
    }

    @Override
    public PropExpression.Num<Long> unionId() {
        return __get(RoleEntityProps.UNION_ID.unwrap());
    }

    @Override
    public PropExpression.Num<Long> createBy() {
        return __get(RoleEntityProps.CREATE_BY.unwrap());
    }

    @Override
    public PropExpression.Tp<LocalDateTime> createTime() {
        return __get(RoleEntityProps.CREATE_TIME.unwrap());
    }

    @Override
    public PropExpression.Num<Long> updateBy() {
        return __get(RoleEntityProps.UPDATE_BY.unwrap());
    }

    @Override
    public PropExpression.Tp<LocalDateTime> updateTime() {
        return __get(RoleEntityProps.UPDATE_TIME.unwrap());
    }

    @Override
    public PropExpression.Num<Long> deleteBy() {
        return __get(RoleEntityProps.DELETE_BY.unwrap());
    }

    @Override
    public PropExpression.Tp<LocalDateTime> deleteTime() {
        return __get(RoleEntityProps.DELETE_TIME.unwrap());
    }

    @Override
    public RoleEntityTableEx asTableEx() {
        return new RoleEntityTableEx(this, null);
    }

    @Override
    public RoleEntityTable __disableJoin(String reason) {
        return new RoleEntityTable(this, reason);
    }

    @GeneratedBy(
            type = RoleEntity.class
    )
    public static class Remote extends AbstractTypedTable<RoleEntity> {
        public Remote(AbstractTypedTable.DelayedOperation delayedOperation) {
            super(RoleEntity.class, delayedOperation);
        }

        public Remote(TableImplementor<RoleEntity> table) {
            super(table);
        }

        public PropExpression.Num<Long> id() {
            return __get(RoleEntityProps.ID.unwrap());
        }

        @Override
        @Deprecated
        public TableEx<RoleEntity> asTableEx() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Remote __disableJoin(String reason) {
            return this;
        }
    }
}
