package io.github.yibird.starter.core.enums;

import java.util.Objects;

/**
 * @Description 基础枚举接口
 * @Author zchengfeng
 * @Datetime 2025/3/5 2:59
 */
public interface BaseEnum<T> {
    /**
     * 枚举值
     *
     * @return 枚举值
     */
    T getValue();

    /**
     * 枚举描述
     *
     * @return 枚举描述
     */
    String getDescription();

    /**
     * 颜色
     *
     * @return 颜色
     */
    default String getColor() {
        return null;
    }

    /**
     * 根据枚举值获取
     *
     * @param value 枚举值
     * @param clazz 枚举类
     * @return 枚举对象
     */
    static <E extends Enum<E> & BaseEnum<T>, T> E getByValue(T value, Class<E> clazz) {
        for (E e : clazz.getEnumConstants()) {
            if (Objects.equals(e.getValue(), value)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 根据枚举描述获取
     *
     * @param description 枚举描述
     * @param clazz       枚举类
     * @return 枚举对象
     */
    static <E extends Enum<E> & BaseEnum<T>, T> E getByDescription(String description, Class<E> clazz) {
        for (E e : clazz.getEnumConstants()) {
            if (Objects.equals(e.getDescription(), description)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 判断枚举值是否有效
     *
     * @param value 枚举值
     * @param clazz 枚举类
     * @return 是否有效
     */
    static <E extends Enum<E> & BaseEnum<T>, T> boolean isValidValue(T value, Class<E> clazz) {
        return getByValue(value, clazz) != null;
    }
}
