package io.github.yibird.starter.idempotent.aspect;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.text.CharSequenceUtil;
import io.github.yibird.starter.cache.redisson.utils.RedisUtils;
import io.github.yibird.starter.core.utils.expression.ExpressionUtils;
import io.github.yibird.starter.idempotent.annotation.Idempotent;
import io.github.yibird.starter.idempotent.autoconfigure.IdempotentProperties;
import io.github.yibird.starter.idempotent.exception.IdempotentException;
import io.github.yibird.starter.idempotent.generator.IdempotentNameGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * @Description 幂等性切面
 * @Author zchengfeng
 * @Datetime 2025/6/10 15:53
 */
@Aspect
public class IdempotentAspect {

    private final IdempotentProperties properties;
    private final IdempotentNameGenerator nameGenerator;

    public IdempotentAspect(IdempotentProperties properties, IdempotentNameGenerator nameGenerator) {
        this.properties = properties;
        this.nameGenerator = nameGenerator;
    }

    @Around("@annotation(idempotent)")
    public Object around(ProceedingJoinPoint joinPoint, Idempotent idempotent) throws Throwable {
        String cacheKey = this.getCacheKey(joinPoint, idempotent);
        Duration duration = Duration.ofMillis(idempotent.unit().toMillis(idempotent.timeout()));
        // 如果cacheKey存在则违反了幂等性,抛出IdempotentException异常
        if (!RedisUtils.setIfAbsent(cacheKey, "", duration)) {
            throw new IdempotentException(idempotent.message());
        }
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            RedisUtils.delete(cacheKey);
            throw e;
        }
    }

    private String getCacheKey(ProceedingJoinPoint joinPoint, Idempotent idempotent) {
        Object target = joinPoint.getTarget();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();
        // 获取名称
        String name = idempotent.name();
        if (CharSequenceUtil.isBlank(name)) {
            name = nameGenerator.generate(target, method, args);
        }
        String key = idempotent.key();
        if (CharSequenceUtil.isNotBlank(key)) {
            Object eval = ExpressionUtils.eval(key, target, method, args);
            if (eval == null) {
                throw new IdempotentException("幂等 Key 解析错误");
            }
            key = Convert.toStr(eval);
        }
        return RedisUtils.formatKey(properties.getKeyPrefix(), name, key);
    }
}
