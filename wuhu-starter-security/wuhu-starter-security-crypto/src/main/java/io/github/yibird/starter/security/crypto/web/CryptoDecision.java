package io.github.yibird.starter.security.crypto.web;

import io.github.yibird.starter.security.crypto.annotation.Decrypt;
import io.github.yibird.starter.security.crypto.annotation.Encrypt;
import io.github.yibird.starter.security.crypto.autoconfigure.CryptoProperties;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/8/14 16:45
 */
@Component
public class CryptoDecision {

    private final CryptoProperties cryptoProperties;
    private final AntPathMatcher matcher = new AntPathMatcher();

    public CryptoDecision(CryptoProperties cryptoProperties) {
        this.cryptoProperties = cryptoProperties;
    }

    /**
     * 是否需要解密
     *
     * @param req     HttpServletRequest
     * @param handler HandlerMethod
     * @return 布尔值
     */
    public boolean needDecrypt(HttpServletRequest req, HandlerMethod handler) {
        if (!cryptoProperties.isEnabled()) {
            return false;
        }
        if (hasAnnotation(handler, Decrypt.class)) {
            return true;
        }
        return matchGlobal(req);
    }

    public boolean needEncrypt(HttpServletRequest req, HandlerMethod handler) {
        if (!cryptoProperties.isEnabled()) {
            return false;
        }
        if (hasAnnotation(handler, Encrypt.class)) {
            return true;
        }
        return matchGlobal(req);
    }

    private boolean matchGlobal(HttpServletRequest req) {
        String path = req.getRequestURI();
        List<String> include = cryptoProperties.getIncludes();
        if (include == null || include.isEmpty()) return false; // 未配置则不生效
        boolean in = include.stream().filter(Objects::nonNull).anyMatch(p -> matcher.match(p, path));
        if (!in) return false;
        List<String> exclude = cryptoProperties.getExcludes();
        if (exclude == null || exclude.isEmpty()) return true;
        boolean ex = exclude.stream().filter(Objects::nonNull).anyMatch(p -> matcher.match(p, path));
        return !ex;
    }

    /**
     * 判断是否有指定类型注解（支持类继承）
     *
     * @param handlerMethod  HandlerMethod
     * @param annotationType annotationType
     * @return 布尔值
     */
    private static boolean hasAnnotation(HandlerMethod handlerMethod, Class<? extends Annotation> annotationType) {
        return AnnotatedElementUtils.hasAnnotation(handlerMethod.getMethod(), annotationType) ||
                AnnotatedElementUtils.hasAnnotation(handlerMethod.getBeanType(), annotationType);
    }
}
