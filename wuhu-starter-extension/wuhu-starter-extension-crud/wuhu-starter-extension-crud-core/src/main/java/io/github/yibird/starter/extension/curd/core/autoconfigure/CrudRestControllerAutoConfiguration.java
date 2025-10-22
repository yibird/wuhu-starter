package io.github.yibird.starter.extension.curd.core.autoconfigure;

import io.github.yibird.starter.extension.curd.core.annotation.CrudApi;
import io.github.yibird.starter.extension.curd.core.aspect.CrudApiAnnotationAdvisor;
import io.github.yibird.starter.extension.curd.core.aspect.CrudApiAnnotationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @Description CurdRestController自动配置类
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:59
 */
@AutoConfiguration
@EnableConfigurationProperties(CrudProperties.class)
public class CrudRestControllerAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(CrudRestControllerAutoConfiguration.class);

    /**
     * CRUD API 注解通知
     */
    @Bean
    @ConditionalOnMissingBean
    public CrudApiAnnotationAdvisor crudApiAnnotationAdvisor(CrudApiAnnotationInterceptor crudApiAnnotationInterceptor) {
        return new CrudApiAnnotationAdvisor(crudApiAnnotationInterceptor, CrudApi.class);
    }

    /**
     * CRUD API 注解拦截器
     */
    @Bean
    @ConditionalOnMissingBean
    public CrudApiAnnotationInterceptor crudApiAnnotationInterceptor() {
        return new CrudApiAnnotationInterceptor();
    }
}
