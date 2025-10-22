package io.github.yibird.starter.security.crypto.exception;

/**
 * @Description 解密异常类
 * @Author zchengfeng
 * @Datetime 2025/8/14 17:22
 */
public class DecryptionException extends RuntimeException {

    public DecryptionException(String message) {
        super(message);
    }

    public DecryptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecryptionException(Throwable cause) {
        super("Decryption failed: " + (cause != null ? cause.getMessage() : "Unknown error"), cause);
    }
}
