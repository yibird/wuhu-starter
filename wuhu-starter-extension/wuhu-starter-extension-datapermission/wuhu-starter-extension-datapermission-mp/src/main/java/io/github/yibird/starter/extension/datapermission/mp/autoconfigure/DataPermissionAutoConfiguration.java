package io.github.yibird.starter.extension.datapermission.mp.autoconfigure;

import com.baomidou.mybatisplus.extension.plugins.handler.DataPermissionHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DataPermissionInterceptor;
import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.extension.datapermission.core.autoconfigure.DataPermissionProperties;
import io.github.yibird.starter.extension.datapermission.core.store.DataPermissionUserContextProvider;
import io.github.yibird.starter.extension.datapermission.mp.handler.DefaultDataPermissionHandler;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ResolvableType;

/**
 * @Description 数据权限自动配置类
 * @Author zchengfeng
 * @Datetime 2025/4/29 09:53
 */
@AutoConfiguration
@EnableConfigurationProperties(DataPermissionProperties.class)
@ConditionalOnProperty(prefix = PropertiesConstants.DATA_PERMISSION, name = PropertiesConstants.ENABLED, havingValue = "true", matchIfMissing = true)
public class DataPermissionAutoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DataPermissionAutoConfiguration.class);

    /**
     * 数据权限用户上下文提供者
     * @return DataPermissionUserContextProvider
     */
    @Bean
    @ConditionalOnMissingBean
    public DataPermissionUserContextProvider dataPermissionUserContextProvider() {
        if (log.isErrorEnabled()) {
            log.error("Consider defining a bean of type '{}' in your configuration.",
                    ResolvableType.forClass(DataPermissionUserContextProvider.class));
        }
        throw new NoSuchBeanDefinitionException(DataPermissionUserContextProvider.class);
    }

    /**
     * 数据权限处理器
     * @param dataPermissionUserContextProvider 数据权限用户上下文提供者
     * @return 数据权限处理器
     */
    @Bean
    @ConditionalOnMissingBean
    public DataPermissionHandler dataPermissionHandler(DataPermissionUserContextProvider dataPermissionUserContextProvider) {
        return new DefaultDataPermissionHandler(dataPermissionUserContextProvider);
    }

    @Bean
    @ConditionalOnMissingBean
    public DataPermissionInterceptor dataPermissionInterceptor(DataPermissionHandler dataPermissionHandler) {
        return new DataPermissionInterceptor(dataPermissionHandler);
    }

    @PostConstruct
    public void init() {
        log.debug("[Wuhu Starter] - Auto Configuration 'DataPermission' completed initialization.");
    }
}
