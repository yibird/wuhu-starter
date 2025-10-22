package io.github.yibird.starter.web.autoconfigure.mvc;

import io.github.yibird.starter.core.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description BaseEnum转换器
 * @Author zchengfeng
 * @Datetime 2025/3/17 2:22
 */
public class BaseEnumConverter<T extends BaseEnum> implements Converter<String, T> {

    private final Map<String, T> enumMap = new HashMap<>();

    public BaseEnumConverter(Class<T> enumType) {
        T[] enums = enumType.getEnumConstants();
        for (T e : enums) {
            enumMap.put(String.valueOf(e.getValue()), e);
        }
    }

    @Override
    public T convert(String source) {
        return enumMap.get(source);
    }
}
