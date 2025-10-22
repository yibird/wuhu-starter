package io.github.yibird.starter.idempotent.autoconfigure;

import io.github.yibird.starter.cache.redisson.autoconfigure.RedissonAutoConfiguration;
import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.idempotent.aspect.IdempotentAspect;
import io.github.yibird.starter.idempotent.generator.DefaultIdempotentNameGenerator;
import io.github.yibird.starter.idempotent.generator.IdempotentNameGenerator;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


/**
 * @Description 幂等性自动配置类
 * @Author zchengfeng
 * @Datetime 2025/6/10 15:48
 */
@AutoConfiguration(after = RedissonAutoConfiguration.class)
@EnableConfigurationProperties(IdempotentProperties.class)
@ConditionalOnProperty(prefix = PropertiesConstants.IDEMPOTENT, name = PropertiesConstants.ENABLED, havingValue = "true", matchIfMissing = true)
public class IdempotentAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(IdempotentAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public IdempotentNameGenerator idempotentNameGenerator() {
        return new DefaultIdempotentNameGenerator();
    }

    @Bean
    public IdempotentAspect idempotentAspect(IdempotentProperties properties,
                                             IdempotentNameGenerator idempotentNameGenerator) {
        return new IdempotentAspect(properties, idempotentNameGenerator);
    }

    @PostConstruct
    public void postConstruct() {
        log.debug("[Wuhu Starter] - Auto Configuration 'Idempotent' completed initialization.");
    }
}
