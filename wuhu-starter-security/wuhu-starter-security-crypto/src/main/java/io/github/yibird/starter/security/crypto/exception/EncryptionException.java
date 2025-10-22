package io.github.yibird.starter.security.crypto.exception;

/**
 * @Description 加密异常类
 * @Author zchengfeng
 * @Datetime 2025/8/14 17:21
 */
public class EncryptionException extends RuntimeException {

    public EncryptionException(String message) {
        super(message);
    }

    public EncryptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public EncryptionException(Throwable cause) {
        super("Encryption failed: " + (cause != null ? cause.getMessage() : "Unknown error"), cause);
    }
}
