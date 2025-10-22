package io.github.yibird.starter.security.crypto.autoconfigure;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/8/14 15:00
 */
@ConfigurationProperties(PropertiesConstants.SECURITY_CRYPTO)
public class CryptoProperties {
    /**
     * 是否开启请求参数、响应体加解密
     */
    private boolean enabled = true;
    /**
     * 指定需要加解密的api path表达式列表
     */
    private List<String> includes;
    /**
     * 排除需要加解密的api path表达式列表
     */
    private List<String> excludes;
    /**
     * 跳过加解密的请求头
     */
    private String skipHeader = "X-CRYPTO-SKIP";

    private String keyBase64;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getIncludes() {
        return includes;
    }

    public void setIncludes(List<String> includes) {
        this.includes = includes;
    }

    public List<String> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }

    public String getSkipHeader() {
        return skipHeader;
    }

    public void setSkipHeader(String skipHeader) {
        this.skipHeader = skipHeader;
    }

    public String getKeyBase64() {
        return keyBase64;
    }

    public void setKeyBase64(String keyBase64) {
        this.keyBase64 = keyBase64;
    }
}
