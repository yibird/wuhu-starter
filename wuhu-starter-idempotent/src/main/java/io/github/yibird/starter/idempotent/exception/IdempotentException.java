
package io.github.yibird.starter.idempotent.exception;

import io.github.yibird.starter.core.exception.BaseException;

/**
 * @Description 幂等异常
 * @Author zchengfeng
 * @Datetime 2025/6/10 15:37
 */
public class IdempotentException extends BaseException {

    public IdempotentException(String message) {
        super(message);
    }

    public IdempotentException(String message, Throwable cause) {
        super(message, cause);
    }
}
