package io.github.yibird.starter.security.crypto.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.yibird.starter.security.crypto.autoconfigure.CryptoProperties;
import io.github.yibird.starter.security.crypto.exception.DecryptionException;
import io.github.yibird.starter.security.crypto.utils.AesGcm;
import io.github.yibird.starter.web.utils.SpringWebUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * @Description 解密请求体Advice
 * @Author zchengfeng
 * @Datetime 2025/8/14 15:12
 */
public class DecryptRequestBodyAdvice extends RequestBodyAdviceAdapter {


    private final CryptoProperties cryptoProperties;
    private final CryptoDecision decision;
    private final ObjectMapper mapper;
    private final HttpServletRequest request;
    private volatile byte[] key;

    public DecryptRequestBodyAdvice(CryptoProperties cryptoProperties, CryptoDecision decision, ObjectMapper mapper, HttpServletRequest request) {
        this.cryptoProperties = cryptoProperties;
        this.decision = decision;
        this.mapper = mapper;
        this.request = request;
    }


    @Override
    public boolean supports(@NonNull MethodParameter methodParameter, @NonNull Type targetType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        String ct = request.getContentType();
        // 跳过大文件上传
        return ct == null || !ct.toLowerCase().startsWith("multipart/");
    }

    @NotNull
    @Override
    public HttpInputMessage beforeBodyRead(@NonNull HttpInputMessage inputMessage, @NonNull MethodParameter parameter, @NonNull Type targetType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        HandlerMethod handler = SpringWebUtils.getHandlerMethod();
        if (handler == null) {
            return inputMessage;
        }
        if (!decision.needDecrypt(request, handler)) {
            return inputMessage;
        }

        // 读取密文信封
        try (InputStream is = inputMessage.getBody()) {
            JsonNode node = mapper.readTree(is);
            String ivB64 = node.get("iv").asText();
            String cipherB64 = node.get("cipher").asText();
            byte[] iv = AesGcm.base64Decode(ivB64);
            byte[] cipher = AesGcm.base64Decode(cipherB64);
            byte[] plain = AesGcm.decrypt(loadKey(), iv, cipher);
            // 将明文 JSON 字节提供给后续消息转换器
            return new SimpleHttpInputMessage(plain, inputMessage.getHeaders());
        } catch (Exception ex) {
            throw new DecryptionException("Invalid encrypted request body", ex);
        }
    }

    private byte[] loadKey() {
        if (key == null) {
            synchronized (this) {
                if (key == null) key = AesGcm.base64Decode(cryptoProperties.getKeyBase64());
            }
        }
        return key;
    }

    static class SimpleHttpInputMessage implements HttpInputMessage {
        private final ByteArrayInputStream bais;
        private final HttpHeaders headers;

        SimpleHttpInputMessage(byte[] body, HttpHeaders headers) {
            this.bais = new ByteArrayInputStream(body);
            this.headers = headers;
        }

        @NotNull
        @Override
        public InputStream getBody() {
            return bais;
        }

        @NotNull
        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
    }
}
