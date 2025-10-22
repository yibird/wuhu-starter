package io.github.yibird.starter.extension.tenant.core.autoconfigure;

import io.github.yibird.starter.extension.tenant.core.annotation.TenantIgnore;
import io.github.yibird.starter.extension.tenant.core.context.TenantContextHolder;
import io.github.yibird.starter.extension.tenant.core.store.TenantProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description  租户拦截器
 * @Author zchengfeng
 * @Datetime 2025/4/28 14:26
 */
public class TenantInterceptor implements HandlerInterceptor, Ordered {

    private final TenantProperties tenantProperties;
    private final TenantProvider tenantProvider;

    public TenantInterceptor(TenantProperties tenantProperties, TenantProvider tenantProvider) {
        this.tenantProperties = tenantProperties;
        this.tenantProvider = tenantProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果方法带有@TenantIgnore注解则直接放行
        if (handler instanceof HandlerMethod handlerMethod) {
            TenantIgnore tenantIgnore = handlerMethod.getMethodAnnotation(TenantIgnore.class);
            if (tenantIgnore != null) {
                return true;
            }
        }
        // 获取租户id并存储到TenantContextHolder类
        String tenantId = request.getHeader(tenantProperties.getTenantIdHeader());
        TenantContextHolder.setContext(tenantProvider.getByTenantId(tenantId, true));
        return true;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
