package io.github.yibird.starter.security.crypto.annotation;

import java.lang.annotation.*;

/**
 * @Description 加密注解
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:49
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Encrypt {

}
