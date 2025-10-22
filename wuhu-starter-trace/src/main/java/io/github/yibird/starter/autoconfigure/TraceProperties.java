package io.github.yibird.starter.autoconfigure;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @Description 链路追踪配置属性类
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:20
 */
@ConfigurationProperties(PropertiesConstants.TRACE)
public class TraceProperties {
    /**
     * 是否启用链路追踪配置
     */
    private boolean enabled = false;

    /**
     * 链路 ID 名称
     */
    private String traceIdName = "traceId";

    @NestedConfigurationProperty
    private TLogProperties tlog;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTraceIdName() {
        return traceIdName;
    }

    public void setTraceIdName(String traceIdName) {
        this.traceIdName = traceIdName;
    }

    public TLogProperties getTlog() {
        return tlog;
    }

    public void setTlog(TLogProperties tlog) {
        this.tlog = tlog;
    }
}
