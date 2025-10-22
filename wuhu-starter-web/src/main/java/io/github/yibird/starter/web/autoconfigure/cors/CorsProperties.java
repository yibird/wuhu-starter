package io.github.yibird.starter.web.autoconfigure.cors;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.core.constant.StringConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 跨域属性类
 * @Author zchengfeng
 * @Datetime 2025/3/17 1:12
 */
@ConfigurationProperties(PropertiesConstants.WEB_CORS)
public class CorsProperties {

    private static final List<String> ALL = Collections.singletonList(StringConstants.ASTERISK);

    /**
     * 是否允许跨域
     */
    private boolean enabled = false;

    /**
     * 允许跨域的域名
     */
    private List<String> allowedOrigins = new ArrayList<>(ALL);

    /**
     * 允许跨域的请求方式
     */
    private List<String> allowedMethods = new ArrayList<>(ALL);

    /**
     * 允许跨域的请求头
     */
    private List<String> allowedHeaders = new ArrayList<>(ALL);

    /**
     * 允许跨域的响应头
     */
    private List<String> exposedHeaders = new ArrayList<>();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public List<String> getAllowedMethods() {
        return allowedMethods;
    }

    public void setAllowedMethods(List<String> allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public List<String> getAllowedHeaders() {
        return allowedHeaders;
    }

    public void setAllowedHeaders(List<String> allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    public List<String> getExposedHeaders() {
        return exposedHeaders;
    }

    public void setExposedHeaders(List<String> exposedHeaders) {
        this.exposedHeaders = exposedHeaders;
    }
}
