package io.github.yibird.starter.ratelimiter.autoconfigure;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description 限流配置类
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:58
 */
@ConfigurationProperties(PropertiesConstants.RATE_LIMITER)
public class RateLimiterProperties {
    /**
     * 是否开启限流
     */
    private boolean enabled = true;
    /**
     * Key 前缀
     */
    private String keyPrefix = "rateLimiter";

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
