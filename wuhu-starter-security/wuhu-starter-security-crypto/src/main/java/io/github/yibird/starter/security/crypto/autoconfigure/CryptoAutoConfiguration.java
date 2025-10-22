package io.github.yibird.starter.security.crypto.autoconfigure;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/8/14 15:10
 */
@EnableConfigurationProperties(CryptoProperties.class)
@ConditionalOnProperty(prefix = PropertiesConstants.SECURITY_CRYPTO, name = PropertiesConstants.ENABLED, havingValue = "true")
public class CryptoAutoConfiguration {

}
