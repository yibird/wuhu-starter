package io.github.yibird.model.entity;

import java.lang.Override;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.lang.NewChain;
import org.babyfish.jimmer.meta.ImmutableProp;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.babyfish.jimmer.sql.fetcher.FieldConfig;
import org.babyfish.jimmer.sql.fetcher.IdOnlyFetchType;
import org.babyfish.jimmer.sql.fetcher.impl.FetcherImpl;
import org.babyfish.jimmer.sql.fetcher.spi.AbstractTypedFetcher;

@GeneratedBy(
        type = RoleEntity.class
)
public class RoleEntityFetcher extends AbstractTypedFetcher<RoleEntity, RoleEntityFetcher> {
    public static final RoleEntityFetcher $ = new RoleEntityFetcher(null);

    private RoleEntityFetcher(FetcherImpl<RoleEntity> base) {
        super(RoleEntity.class, base);
    }

    private RoleEntityFetcher(RoleEntityFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private RoleEntityFetcher(RoleEntityFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static RoleEntityFetcher $from(Fetcher<RoleEntity> base) {
        return base instanceof RoleEntityFetcher ? 
        	(RoleEntityFetcher)base : 
        	new RoleEntityFetcher((FetcherImpl<RoleEntity>)base);
    }

    @NewChain
    public RoleEntityFetcher roleName() {
        return add("roleName");
    }

    @NewChain
    public RoleEntityFetcher roleName(boolean enabled) {
        return enabled ? add("roleName") : remove("roleName");
    }

    @NewChain
    public RoleEntityFetcher dataScope() {
        return add("dataScope");
    }

    @NewChain
    public RoleEntityFetcher dataScope(boolean enabled) {
        return enabled ? add("dataScope") : remove("dataScope");
    }

    @NewChain
    public RoleEntityFetcher dataStatus() {
        return add("dataStatus");
    }

    @NewChain
    public RoleEntityFetcher dataStatus(boolean enabled) {
        return enabled ? add("dataStatus") : remove("dataStatus");
    }

    @NewChain
    public RoleEntityFetcher remark() {
        return add("remark");
    }

    @NewChain
    public RoleEntityFetcher remark(boolean enabled) {
        return enabled ? add("remark") : remove("remark");
    }

    @NewChain
    public RoleEntityFetcher version() {
        return add("version");
    }

    @NewChain
    public RoleEntityFetcher version(boolean enabled) {
        return enabled ? add("version") : remove("version");
    }

    @NewChain
    public RoleEntityFetcher sort() {
        return add("sort");
    }

    @NewChain
    public RoleEntityFetcher sort(boolean enabled) {
        return enabled ? add("sort") : remove("sort");
    }

    @NewChain
    public RoleEntityFetcher deleted() {
        return add("deleted");
    }

    @NewChain
    public RoleEntityFetcher deleted(boolean enabled) {
        return enabled ? add("deleted") : remove("deleted");
    }

    @NewChain
    public RoleEntityFetcher unionId() {
        return add("unionId");
    }

    @NewChain
    public RoleEntityFetcher unionId(boolean enabled) {
        return enabled ? add("unionId") : remove("unionId");
    }

    @NewChain
    public RoleEntityFetcher createBy() {
        return add("createBy");
    }

    @NewChain
    public RoleEntityFetcher createBy(boolean enabled) {
        return enabled ? add("createBy") : remove("createBy");
    }

    @NewChain
    public RoleEntityFetcher createTime() {
        return add("createTime");
    }

    @NewChain
    public RoleEntityFetcher createTime(boolean enabled) {
        return enabled ? add("createTime") : remove("createTime");
    }

    @NewChain
    public RoleEntityFetcher updateBy() {
        return add("updateBy");
    }

    @NewChain
    public RoleEntityFetcher updateBy(boolean enabled) {
        return enabled ? add("updateBy") : remove("updateBy");
    }

    @NewChain
    public RoleEntityFetcher updateTime() {
        return add("updateTime");
    }

    @NewChain
    public RoleEntityFetcher updateTime(boolean enabled) {
        return enabled ? add("updateTime") : remove("updateTime");
    }

    @NewChain
    public RoleEntityFetcher deleteBy() {
        return add("deleteBy");
    }

    @NewChain
    public RoleEntityFetcher deleteBy(boolean enabled) {
        return enabled ? add("deleteBy") : remove("deleteBy");
    }

    @NewChain
    public RoleEntityFetcher deleteTime() {
        return add("deleteTime");
    }

    @NewChain
    public RoleEntityFetcher deleteTime(boolean enabled) {
        return enabled ? add("deleteTime") : remove("deleteTime");
    }

    @Override
    protected RoleEntityFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new RoleEntityFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected RoleEntityFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new RoleEntityFetcher(this, prop, fieldConfig);
    }
}
