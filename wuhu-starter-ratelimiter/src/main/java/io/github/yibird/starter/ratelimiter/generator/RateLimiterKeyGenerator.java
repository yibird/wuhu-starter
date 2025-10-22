package io.github.yibird.starter.ratelimiter.generator;

import java.lang.reflect.Method;

/**
 * @Description 限流key生成器接口
 * @Author zchengfeng
 * @Datetime 2025/3/27 17:11
 */
@FunctionalInterface
public interface RateLimiterKeyGenerator {
    String generate(Object target, Method method, Object... args);
}
