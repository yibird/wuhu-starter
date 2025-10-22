package io.github.yibird.starter.ratelimiter.annotation;

import io.github.yibird.starter.ratelimiter.enums.LimitStrategy;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @Description 限流注解
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:49
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimiter {
    /**
     * 限流策略
     */
    LimitStrategy strategy() default LimitStrategy.DEFAULT;

    /**
     * 限流名称
     */
    String name() default "";

    /**
     * 限流key,支持Spring EL表达式
     */
    String key() default "";

    /**
     * 速率（指定时间间隔产生的令牌数）
     */
    int rate() default Integer.MAX_VALUE;

    /**
     * 速率间隔（时间间隔）
     */
    int interval() default 0;

    /**
     * 速率间隔时间单位（默认：毫秒）
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;

    /**
     * 提示信息
     */
    String message() default "操作过于频繁，请稍后再试";
}
