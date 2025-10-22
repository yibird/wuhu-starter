package io.github.yibird.starter.extension.tenant.core.context;

import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.ttl.TransmittableThreadLocal;
import io.github.yibird.starter.extension.tenant.core.autoconfigure.TenantProperties;
import io.github.yibird.starter.extension.tenant.core.enums.TenantIsolationLevel;
import io.github.yibird.starter.extension.tenant.core.store.TenantDataSource;

import java.util.Optional;

/**
 * @Description 租户上下文 Holder类
 * @Author zchengfeng
 * @Datetime 2025/4/28 14:43
 */
public class TenantContextHolder {

    private static final TransmittableThreadLocal<TenantContext> CONTEXT_HOLDER = new TransmittableThreadLocal<>();

    public TenantContextHolder() {

    }

    /**
     * 设置租户上下文
     *
     * @param context TenantContext
     */
    public static void setContext(TenantContext context) {
        CONTEXT_HOLDER.set(context);
    }

    /**
     * 获取租户上下文
     *
     * @return TenantContext
     */
    public static TenantContext getContext() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 获取租户 ID
     *
     * @return 租户 ID
     */
    public static Long getTenantId() {
        return Optional.ofNullable(getContext()).map(TenantContext::getTenantId).orElse(null);
    }


    /**
     * 获取租户隔离级别
     *
     * @return 租户隔离级别
     */
    public static TenantIsolationLevel getIsolationLevel() {
        return Optional.ofNullable(getContext())
                .map(TenantContext::getIsolationLevel)
                .orElse(SpringUtil.getBean(TenantProperties.class).getIsolationLevel());
    }

    /**
     * 获取租户数据源
     *
     * @return 租户数据源
     */
    public static TenantDataSource getDataSource() {
        return Optional.ofNullable(getContext()).map(TenantContext::getDataSource).orElse(null);
    }

}
