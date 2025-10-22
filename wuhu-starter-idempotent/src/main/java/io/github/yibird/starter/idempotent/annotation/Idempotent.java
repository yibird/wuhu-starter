package io.github.yibird.starter.idempotent.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @Description 幂等性注解(基于Redis实现)
 * @Author zchengfeng
 * @Datetime 2025/6/10 15:37
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {

    String name() default "";

    /**
     * 键（支持 Spring EL 表达式）
     */
    String key() default "";

    /**
     * 超时时间
     */
    int timeout() default 1000;

    /**
     * 时间单位（默认：毫秒）
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;

    /**
     * 重复时提示消息
     */
    String message() default "请勿重复操作";
}
