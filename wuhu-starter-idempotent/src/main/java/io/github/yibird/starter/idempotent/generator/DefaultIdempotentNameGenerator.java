package io.github.yibird.starter.idempotent.generator;

import cn.hutool.core.util.ClassUtil;
import io.github.yibird.starter.core.constant.StringConstants;
import net.dreamlu.mica.core.utils.DigestUtil;
import net.dreamlu.mica.core.utils.JsonUtil;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description 幂等性名称默认实现
 * @Author zchengfeng
 * @Datetime 2025/6/10 16:07
 */
public class DefaultIdempotentNameGenerator implements IdempotentNameGenerator {

    // 使用弱引用缓存避免内存泄漏
    private final Map<Method, String> methodCache = new ConcurrentReferenceHashMap<>();

    @Override
    public String generate(Object target, Method method, Object... args) {
        String methodPart = methodCache.computeIfAbsent(method, m -> target.getClass().getSimpleName() + StringConstants.COLON + m.getName());
        if (args == null || args.length == 0) {
            return methodPart;
        }

        StringBuilder sb = new StringBuilder(methodPart.length() + 33);
        sb.append(methodPart).append(StringConstants.COLON);

        if (args.length == 1 && isSimpleType(args[0])) {
            sb.append(args[0].hashCode());
        } else {
            // 使用JSONUtil序列化参数，然后计算哈希值以确保唯一性
            String argsJson = JsonUtil.toJson(args);
            if (argsJson != null) {
                sb.append(DigestUtil.md5Hex(argsJson));
            }
        }
        return sb.toString();
    }

    private boolean isSimpleType(Object obj) {
        return obj instanceof String ||
                obj instanceof Number ||
                obj instanceof Boolean ||
                obj instanceof Character;
    }
}
