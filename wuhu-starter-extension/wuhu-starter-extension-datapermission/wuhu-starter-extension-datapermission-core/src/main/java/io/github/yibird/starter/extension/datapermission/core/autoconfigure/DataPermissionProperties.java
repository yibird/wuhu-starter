package io.github.yibird.starter.extension.datapermission.core.autoconfigure;

import io.github.yibird.starter.core.constant.PropertiesConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description 数据权限属性类
 * @Author zchengfeng
 * @Datetime 2025/4/29 09:46
 */
@ConfigurationProperties(PropertiesConstants.DATA_PERMISSION)
public class DataPermissionProperties {
    /**
     * 是否启用
     */
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
