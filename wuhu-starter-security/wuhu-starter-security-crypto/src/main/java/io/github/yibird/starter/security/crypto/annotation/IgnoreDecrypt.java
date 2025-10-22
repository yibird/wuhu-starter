package io.github.yibird.starter.security.crypto.annotation;

import java.lang.annotation.*;

/**
 * @Description 忽略解密注解
 * @Author zchengfeng
 * @Datetime 2025/8/14 16:29
 */
@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreDecrypt {
}
