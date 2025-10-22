package io.github.yibird.starter.extension.curd.core.autoconfigure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.lang.NonNull;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * @Description Crud请求映射自动配置类
 * @Author zchengfeng
 * @Datetime 2025/4/7 15:47
 */
@EnableWebMvc
@Configuration
@EnableConfigurationProperties(CrudProperties.class)
public class CrudRequestMappingAutoConfiguration extends DelegatingWebMvcConfiguration {
    /**
     * CRUD 请求映射器处理器映射器（覆盖默认 RequestMappingHandlerMapping）
     */
    @NonNull
    @Override
    public RequestMappingHandlerMapping createRequestMappingHandlerMapping() { 
        return new CrudRequestMappingHandlerMapping();
    }

    @Bean
    @Primary
    @NonNull
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping(@NonNull @Qualifier("mvcContentNegotiationManager") ContentNegotiationManager contentNegotiationManager,
                                                                     @NonNull @Qualifier("mvcConversionService") FormattingConversionService conversionService,
                                                                     @NonNull @Qualifier("mvcResourceUrlProvider") ResourceUrlProvider resourceUrlProvider) {
        return super.requestMappingHandlerMapping(contentNegotiationManager, conversionService, resourceUrlProvider);
    }
}
