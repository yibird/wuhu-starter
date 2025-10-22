package io.github.yibird.starter.core.utils;

import cn.hutool.core.util.TypeUtil;

import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @Description 集合工具类, 提供集合之间的转换方法
 * @Author zchengfeng
 * @Datetime 2024/5/5 13:52:58
 */
public class ClassUtils {

    /**
     * 获取指定类泛型参数类型的Class数组
     *
     * @param clazz 指定类
     * @return 所有泛型类型的Class数组
     */
    public static Class<?>[] getGenericsArgsType(Class<?> clazz) {
        Type[] arguments = TypeUtil.getTypeArguments(clazz);
        if (arguments.length == 0) {
            return new Class<?>[0];
        }
        return Arrays.stream(arguments).map(TypeUtil::getClass).toArray(Class<?>[]::new);
    }
}
