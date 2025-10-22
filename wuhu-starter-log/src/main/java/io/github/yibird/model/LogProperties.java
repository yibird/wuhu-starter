package io.github.yibird.model;

import io.github.yibird.enums.Include;
import io.github.yibird.starter.core.constant.PropertiesConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/11 14:46
 */
@ConfigurationProperties(PropertiesConstants.LOG)
public class LogProperties {
    /**
     * 是否启用
     */
    private boolean enabled = true;

    /**
     * 包含信息
     */
    private Set<Include> includes = Include.defaultIncludes();

    /**
     * 放行路由,url表达式
     */
    private List<String> excludePatterns = new ArrayList<>();
}
