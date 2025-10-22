package io.github.yibird.starter.security.crypto.annotation;

import java.lang.annotation.*;

/**
 * @Description 忽略加密注解
 * @Author zchengfeng
 * @Datetime 2025/8/14 16:30
 */
@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreEncrypt {
}
