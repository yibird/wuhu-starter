package io.github.yibird.starter.idempotent.autoconfigure;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description 幂等性属性类
 * @Author zchengfeng
 * @Datetime 2025/6/10 15:58
 */
@ConfigurationProperties(PropertiesConstants.IDEMPOTENT)
public class IdempotentProperties {

    /**
     * Key 前缀,由于基于Redis实现幂等性,keyPrefix相当于Redis key前缀
     */
    private String keyPrefix = "Idempotent";

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }
}
