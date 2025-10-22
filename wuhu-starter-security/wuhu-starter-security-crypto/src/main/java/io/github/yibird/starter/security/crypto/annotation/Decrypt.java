package io.github.yibird.starter.security.crypto.annotation;

import java.lang.annotation.*;

/**
 * @Description 解密注解,用于类时,适用于该类上所有RequestMapping方法;用于方法时,仅针对方法生效
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:49
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Decrypt {

}
