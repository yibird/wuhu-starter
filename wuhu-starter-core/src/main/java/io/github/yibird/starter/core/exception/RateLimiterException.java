package io.github.yibird.starter.core.exception;

/**
 * @Description 限流异常类
 * @Author zchengfeng
 * @Datetime 2025/4/2 0:19
 */
public class RateLimiterException extends BaseException {

    public RateLimiterException(String message) {
        super(message);
    }

    public RateLimiterException(String message, Throwable cause) {
        super(message, cause);
    }
}
