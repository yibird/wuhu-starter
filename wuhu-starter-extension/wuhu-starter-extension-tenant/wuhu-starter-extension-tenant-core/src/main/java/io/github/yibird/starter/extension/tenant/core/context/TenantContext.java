package io.github.yibird.starter.extension.tenant.core.context;

import io.github.yibird.starter.extension.tenant.core.enums.TenantIsolationLevel;
import io.github.yibird.starter.extension.tenant.core.store.TenantDataSource;

/**
 * @Description 多租户上下文类
 * @Author zchengfeng
 * @Datetime 2025/4/28 14:24
 */
public class TenantContext {
    /**
     * 租户 ID
     */
    private Long tenantId;

    /**
     * 隔离级别
     */
    private TenantIsolationLevel isolationLevel;

    /**
     * 数据源信息
     */
    private TenantDataSource dataSource;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public TenantIsolationLevel getIsolationLevel() {
        return isolationLevel;
    }

    public void setIsolationLevel(TenantIsolationLevel isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

    public TenantDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(TenantDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
