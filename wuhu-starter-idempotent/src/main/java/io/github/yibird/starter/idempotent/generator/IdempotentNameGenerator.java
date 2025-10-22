package io.github.yibird.starter.idempotent.generator;

import java.lang.reflect.Method;

/**
 * @Description 幂等性名称生成器接口
 * @Author zchengfeng
 * @Datetime 2025/6/10 16:06
 */
public interface IdempotentNameGenerator {
    /**
     * 生成幂等性名称
     * @param target 目标实例
     * @param method 目标方法
     * @param args 方法参数
     * @return 幂等性名称
     */
    String generate(Object target, Method method, Object... args);
}
