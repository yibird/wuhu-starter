package io.github.yibird.starter.core.exception;

import java.io.Serial;

/**
 * @Description 基础异常类
 * @Author zchengfeng
 * @Datetime 2024/5/5 14:10
 */
public class BaseException extends RuntimeException {

    @Serial
    private final static long serialVersionUID = 1L;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
