package io.github.yibird.starter.ratelimiter.aspect;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import io.github.yibird.starter.cache.redisson.utils.RedisUtils;
import io.github.yibird.starter.core.constant.StringConstants;
import io.github.yibird.starter.core.utils.expression.ExpressionUtils;
import io.github.yibird.starter.ratelimiter.annotation.RateLimiter;
import io.github.yibird.starter.ratelimiter.annotation.RateLimiters;
import io.github.yibird.starter.ratelimiter.autoconfigure.RateLimiterProperties;
import io.github.yibird.starter.ratelimiter.enums.LimitStrategy;
import io.github.yibird.starter.ratelimiter.exception.RateLimiterException;
import io.github.yibird.starter.ratelimiter.generator.RateLimiterKeyGenerator;
import io.github.yibird.starter.web.utils.ServletUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateLimiterConfig;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/1 23:42
 */
@Aspect
public class RateLimiterAspect {

    private static final ConcurrentHashMap<String, RRateLimiter> LIMITER = new ConcurrentHashMap<>();
    private final RateLimiterProperties properties;
    private final RedissonClient redissonClient;
    private final RateLimiterKeyGenerator generator;

    public RateLimiterAspect(RateLimiterProperties properties, RateLimiterKeyGenerator generator, RedissonClient redissonClient) {
        this.properties = properties;
        this.generator = generator;
        this.redissonClient = redissonClient;
    }

    /**
     * 单个限流器切点
     */
    @Pointcut("@annotation(io.github.yibird.starter.ratelimiter.annotation.RateLimiter)")
    public void rateLimiterPointCut() {
    }

    /**
     * 限流器组切点
     */
    @Pointcut("@annotation(io.github.yibird.starter.ratelimiter.annotation.RateLimiters)")
    public void rateLimitersPointCut() {
    }

    @Around("@annotation(rateLimiter)")
    public Object aroundRateLimiter(ProceedingJoinPoint joinPoint, RateLimiter rateLimiter) throws Throwable {
        if (isRateLimited(joinPoint, rateLimiter)) {
            throw new RateLimiterException(rateLimiter.message());
        }
        return joinPoint.proceed();
    }

    @Around("@annotation(rateLimiters)")
    public Object aroundRateLimiters(ProceedingJoinPoint joinPoint, RateLimiters rateLimiters) throws Throwable {
        for (RateLimiter rateLimiter : rateLimiters.value()) {
            if (isRateLimited(joinPoint, rateLimiter)) {
                throw new RateLimiterException(rateLimiter.message());
            }
        }
        return joinPoint.proceed();
    }


    public boolean isRateLimited(ProceedingJoinPoint joinPoint, RateLimiter rateLimiter) {
        if (!properties.isEnabled()) {
            return false;
        }
        try {
            String cacheKey = this.getKey(joinPoint, rateLimiter);
            RRateLimiter rRateLimiter = LIMITER.computeIfAbsent(cacheKey, key -> redissonClient
                    .getRateLimiter(cacheKey));
            // 限流器配置
            RateType rateType = rateLimiter.strategy() == LimitStrategy.CLUSTER ? RateType.PER_CLIENT : RateType.OVERALL;
            int rate = rateLimiter.rate();
            Duration rateInterval = Duration.ofMillis(rateLimiter.unit().toMillis(rateLimiter.interval()));
            // 判断是否需要更新限流器
            if (this.isConfigurationUpdateNeeded(rRateLimiter, rateType, rate, rateInterval)) {
                // 更新限流器
                rRateLimiter.setRate(rateType, rate, rateInterval);
            }
            // 尝试获取令牌
            return !rRateLimiter.tryAcquire();
        } catch (Exception e) {
            throw new RateLimiterException("服务器限流异常,请稍候再试", e);
        }
    }

    public String getKey(ProceedingJoinPoint joinPoint, RateLimiter rateLimiter) {
        Object target = joinPoint.getTarget();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();
        String name = rateLimiter.name();
        if (CharSequenceUtil.isBlank(name)) {
            name = generator.generate(target, method, args);
        }
        // 解析 Key
        String key = rateLimiter.key();
        if (CharSequenceUtil.isNotBlank(key)) {
            Object eval = ExpressionUtils.eval(key, target, method, args);
            if (ObjectUtil.isNull(eval)) {
                throw new RateLimiterException("限流 Key 解析错误");
            }
            key = Convert.toStr(eval);
        }
        // 获取后缀
        String suffix = switch (rateLimiter.strategy()) {
            case IP -> ServletUtils.getRequestIp();
            case CLUSTER -> redissonClient.getId();
            default -> StringConstants.EMPTY;
        };
        return RedisUtils.formatKey(properties.getKeyPrefix(), name, key, suffix);
    }

    /**
     * 判断是否需要更新限流器配置
     *
     * @param rRateLimiter 限流器
     * @param rateType     限流类型（OVERALL：全局限流；PER_CLIENT：单机限流）
     * @param rate         速率（指定时间间隔产生的令牌数）
     * @param rateInterval 速率间隔
     * @return 是否需要更新配置
     */
    private boolean isConfigurationUpdateNeeded(RRateLimiter rRateLimiter,
                                                RateType rateType,
                                                long rate,
                                                Duration rateInterval) {
        RateLimiterConfig config = rRateLimiter.getConfig();
        return !Objects.equals(config.getRateType(), rateType) || !Objects.equals(config.getRate(), rate) || !Objects
                .equals(config.getRateInterval(), rateInterval.toMillis());
    }
}
