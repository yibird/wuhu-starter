package io.github.yibird.starter.auth.satoken.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description saToken安全属性配置类
 * @Author zchengfeng
 * @Datetime 2025/3/30 21:50
 */
@ConfigurationProperties("sa-token")
public class SaTokenSecurityProperties {

    /**
     * 是否启用扩展
     */
    private boolean enabled = false;

    /**
     * 启用 JWT
     */
    private boolean enableJwt = false;

    /**
     * token 名称,
     */
    private String tokenName ="Authorization";

    /**
     * 排除（放行）路径配置
     */
    private String[] excludes = new String[0];


    public String[] getExcludes() {
        return excludes;
    }

    public void setExcludes(String[] excludes) {
        this.excludes = excludes;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnableJwt() {
        return enableJwt;
    }

    public void setEnableJwt(boolean enableJwt) {
        this.enableJwt = enableJwt;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenName() {
        return tokenName;
    }
}
