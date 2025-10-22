package io.github.yibird.starter.web.autoconfigure.cors;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.core.constant.StringConstants;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Description 跨域自动配置类
 * @Author zchengfeng
 * @Datetime 2025/3/17 1:19
 */
@Lazy
@EnableConfigurationProperties(CorsProperties.class)
@AutoConfiguration
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = PropertiesConstants.WEB_CORS, name = PropertiesConstants.ENABLED, havingValue = "true")
public class CorsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CorsFilter corsFilter(CorsProperties properties) {
        CorsConfiguration config = new CorsConfiguration();
        config.setMaxAge(1800L);
        // 配置允许跨域域名
        if (properties.getAllowedOrigins().contains(StringConstants.ASTERISK)) {
            config.addAllowedOriginPattern(StringConstants.ASTERISK);
        } else {
            // 配置为 true 后则必须配置允许跨域的域名,且不允许配置为 *
            config.setAllowCredentials(true);
            properties.getAllowedOrigins().forEach(config::addAllowedOrigin);
        }

        // 配置允许跨域的请求方式
        properties.getAllowedMethods().forEach(config::addAllowedMethod);
        // 配置允许跨域的请求头
        properties.getAllowedHeaders().forEach(config::addAllowedHeader);
        // 配置允许跨域的响应头
        properties.getExposedHeaders().forEach(config::addExposedHeader);
        // 添加映射路径，拦截一切请求
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(StringConstants.PATH_PATTERN, config);
        return new CorsFilter(source);
    }
}
