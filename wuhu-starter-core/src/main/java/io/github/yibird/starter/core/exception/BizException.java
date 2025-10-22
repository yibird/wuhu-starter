package io.github.yibird.starter.core.exception;

import java.io.Serial;

/**
 * @Description 业务异常类
 * @Author zchengfeng
 * @Datetime 2024/5/5 14:10
 */
public class BizException extends BaseException {
    @Serial
    private final static long serialVersionUID = 1L;

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
