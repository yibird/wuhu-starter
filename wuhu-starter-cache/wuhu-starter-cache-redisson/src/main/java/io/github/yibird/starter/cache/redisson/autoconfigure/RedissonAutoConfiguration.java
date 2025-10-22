package io.github.yibird.starter.cache.redisson.autoconfigure;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.yibird.starter.core.constant.PropertiesConstants;
import io.github.yibird.starter.core.constant.StringConstants;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @Description Redisson自动配置类
 * @Author zchengfeng
 * @Datetime 2025/3/18 1:52
 */
@AutoConfiguration
@EnableConfigurationProperties(RedissonProperties.class)
@ConditionalOnProperty(prefix = "spring.data.redisson", name = PropertiesConstants.ENABLED, havingValue = "true", matchIfMissing = true)
public class RedissonAutoConfiguration {

    private final RedissonProperties properties;
    private final RedisProperties redisProperties;
    private final ObjectMapper objectMapper;

    private static final String REDIS_PROTOCOL_PREFIX = "redis://";
    private static final String REDISS_PROTOCOL_PREFIX = "rediss://";

    public RedissonAutoConfiguration(RedissonProperties properties, RedisProperties redisProperties, ObjectMapper objectMapper) {
        this.properties = properties;
        this.redisProperties = redisProperties;
        this.objectMapper = objectMapper;
    }

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(RedissonAutoConfigurationCustomizer customizer) {
        Config config = new Config();
        customizer.customize(config);
        return Redisson.create(config);
    }

    @Bean
    public RedissonConnectionFactory redissonConnectionFactory(RedissonClient redissonClient) {
        return new RedissonConnectionFactory(redissonClient);
    }

    @Bean
    public RedissonAutoConfigurationCustomizer redissonAutoConfigurationCustomizer() {
        return (config) -> {
            RedissonProperties.Mode mode = properties.getMode();
            // 判断ssl是否启用,若启用则使用rediss协议,否则使用redis协议
            String protocolPrefix = redisProperties.getSsl().isEnabled()
                    ? REDISS_PROTOCOL_PREFIX
                    : REDIS_PROTOCOL_PREFIX;

            switch (mode) {
                case SENTINEL -> this.buildSentinelModeConfig(config, protocolPrefix);
                case CLUSTER -> this.buildClusterModeConfig(config, protocolPrefix);
                default -> this.buildSingleModeConfig(config, protocolPrefix);
            }
            // 使用JsonJacksonCodec作为redisson的编解码器
            config.setCodec(new JsonJacksonCodec(objectMapper));
        };
    }

    /**
     * 构建集群配置
     *
     * @param config         Redisson 配置
     * @param protocolPrefix 协议前缀
     */
    public void buildClusterModeConfig(Config config, String protocolPrefix) {
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        ClusterServersConfig customClusterServersConfig = properties.getClusterServersConfig();
        if (null != customClusterServersConfig) {
            BeanUtil.copyProperties(customClusterServersConfig, clusterServersConfig);
            clusterServersConfig.setNodeAddresses(customClusterServersConfig.getNodeAddresses());
        }
        // 下方配置如果为空,则使用 Redis 的配置
        if (CollUtil.isEmpty(clusterServersConfig.getNodeAddresses())) {
            List<String> nodeList = redisProperties.getCluster().getNodes();
            nodeList.stream().map(node -> protocolPrefix + node).forEach(clusterServersConfig::addNodeAddress);
        }
        if (CharSequenceUtil.isBlank(clusterServersConfig.getPassword())) {
            clusterServersConfig.setPassword(redisProperties.getPassword());
        }
    }

    /**
     * 构建哨兵配置
     *
     * @param config         Redisson 配置
     * @param protocolPrefix 协议前缀
     */
    public void buildSentinelModeConfig(Config config, String protocolPrefix) {
        SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
        SentinelServersConfig customSentinelServersConfig = properties.getSentinelServersConfig();
        if (null != customSentinelServersConfig) {
            BeanUtil.copyProperties(customSentinelServersConfig, sentinelServersConfig);
            sentinelServersConfig.setSentinelAddresses(customSentinelServersConfig.getSentinelAddresses());
        }
        // 下方配置如果为空,则使用 Redis 的配置
        if (CollUtil.isEmpty(sentinelServersConfig.getSentinelAddresses())) {
            List<String> nodeList = redisProperties.getSentinel().getNodes();
            nodeList.stream().map(node -> protocolPrefix + node).forEach(sentinelServersConfig::addSentinelAddress);
        }
        if (CharSequenceUtil.isBlank(sentinelServersConfig.getPassword())) {
            sentinelServersConfig.setPassword(redisProperties.getPassword());
        }
        if (CharSequenceUtil.isBlank(sentinelServersConfig.getMasterName())) {
            sentinelServersConfig.setMasterName(redisProperties.getSentinel().getMaster());
        }
    }

    /**
     * 构建单机配置
     *
     * @param config         Redisson 配置
     * @param protocolPrefix 协议前缀
     */
    public void buildSingleModeConfig(Config config, String protocolPrefix) {
        SingleServerConfig singleServerConfig = config.useSingleServer();
        SingleServerConfig customSingleServerConfig = properties.getSingleServerConfig();
        if (null != customSingleServerConfig) {
            BeanUtil.copyProperties(properties.getSingleServerConfig(), singleServerConfig);
        }
        // 下方配置如果为空,则使用 Redis 的配置
        singleServerConfig.setDatabase(redisProperties.getDatabase());
        if (CharSequenceUtil.isBlank(singleServerConfig.getPassword())) {
            singleServerConfig.setPassword(redisProperties.getPassword());
        }
        if (CharSequenceUtil.isBlank(singleServerConfig.getAddress())) {
            String address = protocolPrefix + redisProperties.getHost() + StringConstants.COLON + redisProperties.getPort();
            singleServerConfig.setAddress(address);
        }
    }
}
