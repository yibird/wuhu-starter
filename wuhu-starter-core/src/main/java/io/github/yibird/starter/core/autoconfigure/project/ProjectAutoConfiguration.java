package io.github.yibird.starter.core.autoconfigure.project;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Description 项目自动配置类
 * @Author zchengfeng
 * @Datetime 2025/3/18 2:47
 */
@AutoConfiguration
@ComponentScan("cn.hutool.extra.spring")
@Import(cn.hutool.extra.spring.SpringUtil.class)
@EnableConfigurationProperties(ProjectProperties.class)
public class ProjectAutoConfiguration {
}
