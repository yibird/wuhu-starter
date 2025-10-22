package io.github.yibird.starter.extension.tenant.core.handler;

/**
 * @Description 租户处理器接口
 * @Author zchengfeng
 * @Datetime 2025/4/28 15:04
 */
public interface TenantHandler {

    /**
     * 在指定租户中执行
     *
     * @param tenantId 租户 ID
     * @param runnable 方法
     */
    void execute(Long tenantId, Runnable runnable);
}
