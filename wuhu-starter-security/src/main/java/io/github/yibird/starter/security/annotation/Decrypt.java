package io.github.yibird.starter.security.annotation;

import java.lang.annotation.*;

/**
 * @Description 解密注解
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:49
 */
@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Decrypt {
}
