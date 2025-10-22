package io.github.yibird.starter.data.jimmer.model;

import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.MappedSuperclass;
import org.babyfish.jimmer.sql.ast.table.Props;

/**
 * @Description 通用接口
 * @Author zchengfeng
 * @Datetime 2025/4/24 15:53
 */
@MappedSuperclass
public interface TenantAware extends Props {
    /**
     * 租户id
     */
    @Column(name = "tenant_id")
    long tenantId();
}
