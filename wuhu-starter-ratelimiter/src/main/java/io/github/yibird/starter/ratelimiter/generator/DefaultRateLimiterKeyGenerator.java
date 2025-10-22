package io.github.yibird.starter.ratelimiter.generator;

import java.lang.reflect.Method;
import java.util.StringJoiner;

/**
 * @Description 默认限流key生成器
 * @Author zchengfeng
 * @Datetime 2025/3/27 17:12
 */
public class DefaultRateLimiterKeyGenerator implements RateLimiterKeyGenerator {

    // 使用StringJoiner的复用减少内存分配（线程安全）
    private static final ThreadLocal<StringJoiner> KEY_JOINER = ThreadLocal.withInitial(
            () -> new StringJoiner(":")
    );

    @Override
    public String generate(Object target, Method method, Object... args) {
        // 1. 获取线程本地的StringJoiner（避免每次new）
        StringJoiner joiner = KEY_JOINER.get();
        joiner.setEmptyValue("");
        // 2. 拼接类名+方法名（占key的80%以上场景）
        joiner.add(target.getClass().getName())
                .add(method.getName());

        // 3. 选择性拼接参数（按需开启）
        if (args != null) {
            for (Object arg : args) {
                joiner.add(argToString(arg));
            }
        }
        // 4. 返回拼接结果
        return joiner.toString();
    }
    // 高性能的参数转字符串方法
    private static String argToString(Object arg) {
        if (arg == null) {
            return "null";
        }

        // 优先使用内存地址（避免调用toString()的性能损耗）
        return Integer.toHexString(System.identityHashCode(arg));

        /* 如果需要完整参数内容（牺牲性能换取精确度）：
        return arg.getClass().isPrimitive() ?
               String.valueOf(arg) :
               Objects.toString(arg);
        */
    }

    // 清理ThreadLocal（防止内存泄漏）
    public void destroy() {
        KEY_JOINER.remove();
    }
}
