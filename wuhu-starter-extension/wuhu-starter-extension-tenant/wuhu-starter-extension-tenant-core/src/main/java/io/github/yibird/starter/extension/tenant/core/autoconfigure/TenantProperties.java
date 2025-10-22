package io.github.yibird.starter.extension.tenant.core.autoconfigure;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.extension.tenant.core.enums.TenantIsolationLevel;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Description 多租户属性类
 * @Author zchengfeng
 * @Datetime 2025/4/28 14:33
 */
@ConfigurationProperties(PropertiesConstants.TENANT)
public class TenantProperties {
    /**
     * 是否启动多租户
     */
    private boolean enabled = true;

    /**
     * 租户隔离级别
     */
    private TenantIsolationLevel isolationLevel = TenantIsolationLevel.LINE;

    /**
     * 租户 ID 列名
     */
    private String tenantIdColumn = "tenant_id";

    /**
     * 请求头中租户 ID 键名
     */
    private String tenantIdHeader = "X-Tenant-Id";

    /**
     * 忽略表（忽略拼接多租户条件）
     */
    private List<String> ignoreTables;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public TenantIsolationLevel getIsolationLevel() {
        return isolationLevel;
    }

    public void setIsolationLevel(TenantIsolationLevel isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

    public String getTenantIdColumn() {
        return tenantIdColumn;
    }

    public void setTenantIdColumn(String tenantIdColumn) {
        this.tenantIdColumn = tenantIdColumn;
    }

    public String getTenantIdHeader() {
        return tenantIdHeader;
    }

    public void setTenantIdHeader(String tenantIdHeader) {
        this.tenantIdHeader = tenantIdHeader;
    }

    public List<String> getIgnoreTables() {
        return ignoreTables;
    }

    public void setIgnoreTables(List<String> ignoreTables) {
        this.ignoreTables = ignoreTables;
    }
}
