package io.github.yibird.starter.security.aspect;

import io.github.yibird.starter.security.annotation.Encrypt;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/3 11:49
 */
@Aspect
@Component
public class EncryptionAspect {

    @Pointcut("@annotation(io.github.yibird.starter.security.annotation.Encrypt)")
    public void encryptPointcut() {
    }

    @Around("@annotation(encrypt)")
    public Object aroundRateLimiter(ProceedingJoinPoint joinPoint, Encrypt encrypt) throws Throwable {
        return joinPoint.proceed();
    }
}
