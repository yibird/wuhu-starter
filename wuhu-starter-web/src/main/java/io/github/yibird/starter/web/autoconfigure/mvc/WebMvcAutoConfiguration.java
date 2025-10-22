package io.github.yibird.starter.web.autoconfigure.mvc;

import jakarta.annotation.PostConstruct;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Objects;

/**
 * @Description SpringMvc自动配置类
 * @Author zchengfeng
 * @Datetime 2025/3/17 2:19
 */
public class WebMvcAutoConfiguration implements WebMvcConfigurer {
    private final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    public WebMvcAutoConfiguration(MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
        this.mappingJackson2HttpMessageConverter = mappingJackson2HttpMessageConverter;
    }

    @PostConstruct
    public void postConstruct() {
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(MappingJackson2HttpMessageConverter.class::isInstance);
        if (Objects.isNull(mappingJackson2HttpMessageConverter)) {
            converters.addFirst(new MappingJackson2HttpMessageConverter());
        } else {
            converters.addFirst(mappingJackson2HttpMessageConverter);
        }
        // 自定义 converters 时，需要手动在最前面添加 ByteArrayHttpMessageConverter
        // 否则 Spring Doc OpenAPI 的 /*/api-docs/**（例如：/v3/api-docs/default）接口响应内容会变为 Base64 编码后的内容，最终导致接口文档解析失败
        // 详情请参阅：https://github.com/springdoc/springdoc-openapi/issues/2143
        converters.addFirst(new ByteArrayHttpMessageConverter());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverterFactory(new BaseEnumConverterFactory());
    }
}
