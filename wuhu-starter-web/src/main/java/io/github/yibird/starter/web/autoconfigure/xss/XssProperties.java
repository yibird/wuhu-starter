package io.github.yibird.starter.web.autoconfigure.xss;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.web.enums.XssMode;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/3/17 1:27
 */
@ConfigurationProperties(PropertiesConstants.WEB_XSS)
public class XssProperties {

    /**
     * 是否启用 XSS 过滤
     */
    private boolean enabled = true;

    /**
     * 拦截路由（默认为空）
     *
     * <p>
     * 当拦截的路由配置不为空，则根据该配置执行过滤
     * </p>
     */
    private List<String> includePatterns = new ArrayList<>();

    /**
     * 放行路由（默认为空）
     */
    private List<String> excludePatterns = new ArrayList<>();

    /**
     * XSS 模式
     */
    private XssMode mode = XssMode.CLEAN;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getIncludePatterns() {
        return includePatterns;
    }

    public void setIncludePatterns(List<String> includePatterns) {
        this.includePatterns = includePatterns;
    }

    public List<String> getExcludePatterns() {
        return excludePatterns;
    }

    public void setExcludePatterns(List<String> excludePatterns) {
        this.excludePatterns = excludePatterns;
    }

    public XssMode getMode() {
        return mode;
    }

    public void setMode(XssMode mode) {
        this.mode = mode;
    }
}
