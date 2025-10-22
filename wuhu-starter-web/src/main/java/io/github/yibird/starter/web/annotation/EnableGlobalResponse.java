package io.github.yibird.starter.web.annotation;

import io.github.yibird.starter.web.autoconfigure.response.GlobalResponseAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description 启用全局响应注解
 * @Author zchengfeng
 * @Datetime 2025/3/17 0:14
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({GlobalResponseAutoConfiguration.class})
public @interface EnableGlobalResponse {

}
