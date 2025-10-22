package io.github.yibird.starter.data.jimmer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.sql.cache.Cache;
import org.babyfish.jimmer.sql.cache.CacheFactory;
import org.babyfish.jimmer.sql.cache.caffeine.CaffeineValueBinder;
import org.babyfish.jimmer.sql.cache.chain.ChainCacheBuilder;
import org.babyfish.jimmer.sql.cache.redis.spring.RedisValueBinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

/**
 * @Description Jimmer配置类
 * @Author zchengfeng
 * @Datetime 2025/4/24 15:37
 */
@Configuration
@ConditionalOnProperty("spring.data.redis.host")
public class JimmerConfig {

    private final ObjectMapper objectMapper;
    private final RedisConnectionFactory connectionFactory;

    public JimmerConfig(ObjectMapper objectMapper, RedisConnectionFactory connectionFactory) {
        this.objectMapper = objectMapper;
        this.connectionFactory = connectionFactory;
    }

    /**
     * 配置缓存工厂
     *
     * @return 缓存工厂实例
     */
    @Bean
    public CacheFactory cacheFactory() {
        return new CacheFactory() {
            @Override
            public Cache<?, ?> createObjectCache(ImmutableType type) {
                return new ChainCacheBuilder<>().add(
                                CaffeineValueBinder.forObject(type)
                                        .maximumSize(1024)
                                        .duration(Duration.ofSeconds(30))
                                        .build()
                        )
                        .add(
                                RedisValueBinder.forObject(type)
                                        .redis(connectionFactory)
                                        .objectMapper(objectMapper)
                                        .duration(Duration.ofSeconds(30))
                                        .build())
                        .build();
            }
        };
    }
}
