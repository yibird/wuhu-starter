package io.github.yibird.starter.cache.redisson.autoconfigure;

import org.redisson.config.ClusterServersConfig;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description Redisson
 * @Author zchengfeng
 * @Datetime 2025/3/18 0:20
 */
@ConfigurationProperties("spring.data.redisson")
public class RedissonProperties {

    /**
     * 是否启用 Redisson
     */
    private boolean enabled = true;

    /**
     * Redis 模式
     */
    private Mode mode = Mode.SINGLE;

    /**
     * redis单机服务配置
     */
    private SingleServerConfig singleServerConfig;

    /**
     * redis集群服务配置
     */
    private ClusterServersConfig clusterServersConfig;

    /**
     * redis哨兵服务配置
     */
    private SentinelServersConfig sentinelServersConfig;

    /**
     * Redis 模式枚举类
     */
    enum Mode {
        /**
         * 单机模式
         */
        SINGLE,
        /**
         * 集群模式
         */
        CLUSTER,
        /**
         * 哨兵模式
         */
        SENTINEL;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public SingleServerConfig getSingleServerConfig() {
        return singleServerConfig;
    }

    public void setSingleServerConfig(SingleServerConfig singleServerConfig) {
        this.singleServerConfig = singleServerConfig;
    }

    public ClusterServersConfig getClusterServersConfig() {
        return clusterServersConfig;
    }

    public void setClusterServersConfig(ClusterServersConfig clusterServersConfig) {
        this.clusterServersConfig = clusterServersConfig;
    }

    public SentinelServersConfig getSentinelServersConfig() {
        return sentinelServersConfig;
    }

    public void setSentinelServersConfig(SentinelServersConfig sentinelServersConfig) {
        this.sentinelServersConfig = sentinelServersConfig;
    }
}
