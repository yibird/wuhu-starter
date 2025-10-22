package io.github.yibird.starter.ratelimiter.autoconfigure;

import io.github.yibird.starter.cache.redisson.autoconfigure.RedissonAutoConfiguration;
import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.ratelimiter.aspect.RateLimiterAspect;
import io.github.yibird.starter.ratelimiter.generator.DefaultRateLimiterKeyGenerator;
import io.github.yibird.starter.ratelimiter.generator.RateLimiterKeyGenerator;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @Description 限流自动配置类
 * @Author zchengfeng
 * @Datetime 2025/3/27 17:05
 */
@AutoConfiguration(after = RedissonAutoConfiguration.class)
@EnableConfigurationProperties(RateLimiterProperties.class)
@ConditionalOnProperty(prefix = PropertiesConstants.RATE_LIMITER, name = PropertiesConstants.ENABLED, havingValue = "true")
public class RateLimiterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public RateLimiterKeyGenerator rateLimiterKeyGenerator() {
        return new DefaultRateLimiterKeyGenerator();
    }

    @Bean
    public RateLimiterAspect rateLimiterAspect(RateLimiterProperties properties,
                                               RateLimiterKeyGenerator keyGenerator,
                                               RedissonClient redissonClient) {
        return new RateLimiterAspect(properties, keyGenerator, redissonClient);
    }
}
