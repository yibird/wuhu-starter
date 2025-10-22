package io.github.yibird.starter.doc.autoconfigure;

import io.swagger.v3.oas.models.Components;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @Description springdoc扩展属性类
 * @Author zchengfeng
 * @Datetime 2025/3/18 2:37
 */
@ConfigurationProperties("springdoc")
public class SpringDocExtensionProperties {
    /**
     * 组件配置（包括鉴权配置等）
     */
    @NestedConfigurationProperty
    private Components components;

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }
}
