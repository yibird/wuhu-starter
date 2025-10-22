package io.github.yibird.starter.extension.tenant.core.store;

import io.github.yibird.starter.extension.tenant.core.context.TenantContext;

/**
 * @Description 多租户提供者接口
 * @Author zchengfeng
 * @Datetime 2025/4/28 14:38
 */
public interface TenantProvider {

    /**
     * 根据租户id获取租户上下午信息
     * @param tenantId 租户id
     * @param isVerify 是否验证
     * @return TenantContext
     */
    TenantContext getByTenantId(String tenantId, boolean isVerify);
}
