package io.github.yibird.starter.security.crypto.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.yibird.starter.security.crypto.autoconfigure.CryptoProperties;
import io.github.yibird.starter.security.crypto.exception.EncryptionException;
import io.github.yibird.starter.security.crypto.utils.AesGcm;
import io.github.yibird.starter.web.utils.SpringWebUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 加密ResponseBodyAdvice
 * @Author zchengfeng
 * @Datetime 2025/8/14 15:14
 */
@Component
@ControllerAdvice
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private final CryptoProperties cryptoProperties;
    private final CryptoDecision decision;
    private final ObjectMapper mapper;
    private volatile byte[] key;

    public EncryptResponseBodyAdvice(CryptoProperties cryptoProperties, CryptoDecision decision, ObjectMapper mapper) {
        this.cryptoProperties = cryptoProperties;
        this.decision = decision;
        this.mapper = mapper;
    }

    @Override
    public boolean supports(@NonNull MethodParameter parameter, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return parameter.getParameterType() != String.class &&
                !parameter.getParameterType().isPrimitive();
    }

    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter returnType, @NonNull MediaType mediaType, @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response) {
        if (!(request instanceof ServletServerHttpRequest req) || !(response instanceof ServletServerHttpResponse resp)) {
            return body;
        }
        HttpServletRequest servletReq = req.getServletRequest();
        HandlerMethod handler = SpringWebUtils.getHandlerMethod();
        if (handler == null) return body;
        if (!decision.needEncrypt(servletReq, handler)) return body;

        try {
            byte[] plain = mapper.writeValueAsBytes(body);
            byte[] iv = AesGcm.randomIV();
            byte[] cipher = AesGcm.encrypt(loadKey(), iv, plain);
            Map<String, String> envelope = new HashMap<>(2);
            envelope.put("iv", AesGcm.base64Encode(iv));
            envelope.put("cipher", AesGcm.base64Encode(cipher));

            // 设置 JSON 响应类型
            resp.getServletResponse().setContentType(MediaType.APPLICATION_JSON_VALUE);
            return envelope;
        } catch (Exception e) {
            throw new EncryptionException("Encrypt response failed", e);
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
}
