package io.github.yibird.model.entity;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.sql.JoinType;
import org.babyfish.jimmer.sql.ast.impl.table.TableImplementor;
import org.babyfish.jimmer.sql.ast.impl.table.TableProxies;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.ast.table.TableEx;
import org.babyfish.jimmer.sql.ast.table.WeakJoin;
import org.babyfish.jimmer.sql.ast.table.spi.AbstractTypedTable;

@GeneratedBy(
        type = RoleEntity.class
)
public class RoleEntityTableEx extends RoleEntityTable implements TableEx<RoleEntity> {
    public static final RoleEntityTableEx $ = new RoleEntityTableEx(RoleEntityTable.$, null);

    public RoleEntityTableEx() {
        super();
    }

    public RoleEntityTableEx(AbstractTypedTable.DelayedOperation<RoleEntity> delayedOperation) {
        super(delayedOperation);
    }

    public RoleEntityTableEx(TableImplementor<RoleEntity> table) {
        super(table);
    }

    protected RoleEntityTableEx(RoleEntityTable base, String joinDisabledReason) {
        super(base, joinDisabledReason);
    }

    @Override
    public RoleEntityTableEx asTableEx() {
        return this;
    }

    @Override
    public RoleEntityTableEx __disableJoin(String reason) {
        return new RoleEntityTableEx(this, reason);
    }

    public <TT extends Table<?>, WJ extends WeakJoin<RoleEntityTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType) {
        return weakJoin(weakJoinType, JoinType.INNER);
    }

    @SuppressWarnings("all")
    public <TT extends Table<?>, WJ extends WeakJoin<RoleEntityTable, TT>> TT weakJoin(
            Class<WJ> weakJoinType, JoinType joinType) {
        __beforeJoin();
        if (raw != null) {
            return (TT)TableProxies.wrap(raw.weakJoinImplementor(weakJoinType, joinType));
        }
        return (TT)TableProxies.fluent(joinOperation(weakJoinType, joinType));
    }
}
