package io.github.yibird.starter.ratelimiter.enums;

/**
 * @Description 限流策略枚举类
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:49
 */
public enum LimitStrategy {
    /**
     * 全局限流
     */
    DEFAULT,
    /**
     * IP限流
     */
    IP,
    /**
     * 根据实例限流（支持集群多实例）
     */
    CLUSTER
}
