package io.github.yibird.starter.web.autoconfigure.xss;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @Description xss自动配置类
 * @Author zchengfeng
 * @Datetime 2025/3/17 1:29
 */
@Lazy
@AutoConfiguration
@ConditionalOnWebApplication
@EnableConfigurationProperties(XssProperties.class)
@ConditionalOnProperty(prefix = PropertiesConstants.WEB_XSS, name = PropertiesConstants.ENABLED, havingValue = "true")
public class XssAutoConfiguration {

    /**
     * XSS 过滤器配置
     */
    @Bean
    public FilterRegistrationBean<XssFilter> xssFilter(XssProperties xssProperties) {
        FilterRegistrationBean<XssFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new XssFilter(xssProperties));
        return registrationBean;
    }
}
