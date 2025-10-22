package io.github.yibird.starter.auth.satoken.autoconfigure;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.core.constant.StringConstants;
import io.github.yibird.starter.core.factory.GeneralPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description saToken自动配置类
 * @Author zchengfeng
 * @Datetime 2025/3/30 21:52
 */
@AutoConfiguration
@EnableConfigurationProperties(SaTokenSecurityProperties.class)
@ConditionalOnProperty(prefix = "sa-token", name = PropertiesConstants.ENABLED, havingValue = "true")
@PropertySource(value = "classpath:satoken-default.yml", factory = GeneralPropertySourceFactory.class)
public class SaTokenAutoConfiguration implements WebMvcConfigurer {

    private final SaTokenSecurityProperties properties;

    public SaTokenAutoConfiguration(SaTokenSecurityProperties properties) {
        this.properties = properties;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(SpringUtil.getBean(SaInterceptor.class)).addPathPatterns(StringConstants.PATH_PATTERN);
    }

    /**
     * SaToken 拦截器配置
     */
    @Bean
    @ConditionalOnMissingBean
    public SaInterceptor saInterceptor() {
        return new SaInterceptor(handle -> {
            SaHolder.getStorage().set(SaManager.getConfig().getTokenName(), properties.getTokenName());
            SaRouter.match(StringConstants.PATH_PATTERN)
                    .notMatch(properties.getExcludes())
                    .check(r -> StpUtil.checkLogin());
        });
    }

}
