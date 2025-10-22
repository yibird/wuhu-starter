package io.github.yibird.starter.ratelimiter.annotation;

import java.lang.annotation.*;

/**
 * @Description 限流组注解
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:55
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimiters {
    /**
     * 限流组
     */
    RateLimiter[] value();
}
