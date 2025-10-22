package io.github.yibird.starter.extension.tenant.core.autoconfigure;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.extension.tenant.core.store.TenantProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 多租户 Web MVC 自动配置类
 * @Author zchengfeng
 * @Datetime 2025/4/28 14:36
 */
@AutoConfiguration
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = PropertiesConstants.TENANT, name = PropertiesConstants.ENABLED, havingValue = "true", matchIfMissing = true)
public class TenantWebMvcAutoConfiguration implements WebMvcConfigurer {
    private final TenantProperties tenantProperties;
    private final TenantProvider tenantProvider;

    public TenantWebMvcAutoConfiguration(TenantProperties tenantProperties, TenantProvider tenantProvider) {
        this.tenantProperties = tenantProperties;
        this.tenantProvider = tenantProvider;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TenantInterceptor(tenantProperties, tenantProvider));
    }
}
