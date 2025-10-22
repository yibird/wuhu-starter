package io.github.yibird.starter.extension.tenant.mp.autoconfigure;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.extension.tenant.core.autoconfigure.TenantProperties;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/28 14:58
 */
@AutoConfiguration
@EnableConfigurationProperties(TenantProperties.class)
@ConditionalOnProperty(prefix = PropertiesConstants.TENANT, name = PropertiesConstants.ENABLED, havingValue = "true", matchIfMissing = true)
public class TenantAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(TenantAutoConfiguration.class);
    private final TenantProperties tenantProperties;

    public TenantAutoConfiguration(TenantProperties tenantProperties) {
        this.tenantProperties = tenantProperties;
    }

    @PostConstruct
    public void postConstruct() {
        log.debug("[Wuhu Starter] - Auto Configuration 'Tenant' completed initialization.");
    }
}
