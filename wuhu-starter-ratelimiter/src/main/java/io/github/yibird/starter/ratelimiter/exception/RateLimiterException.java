package io.github.yibird.starter.ratelimiter.exception;

/**
 * @Description 限流异常
 * @Author zchengfeng
 * @Datetime 2025/3/27 16:57
 */
public class RateLimiterException extends RuntimeException {

    public RateLimiterException(String message) {
        super(message);
    }

    public RateLimiterException(String message, Throwable cause) {
        super(message, cause);
    }
}
