package io.github.yibird.starter.json.jackson.serializer;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import io.github.yibird.starter.core.enums.BaseEnum;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @Description 枚举接口 BaseEnum 反序列化器
 * @Author zchengfeng
 * @Datetime 2025/4/11 13:00
 */
@JacksonStdImpl
public class BaseEnumDeserializer extends JsonDeserializer<BaseEnum> {

    public static final BaseEnumDeserializer SERIALIZER_INSTANCE = new BaseEnumDeserializer();

    @Override
    public BaseEnum deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        // 获取目标字段类型类
        Class<?> targetClass = p.currentValue().getClass();
        // 获取当前字段名称
        String fieldName = p.currentName();
        // 获取字段名称对应的值
        String value = p.getText();
        return this.getEnum(targetClass, fieldName, value);
    }

    /**
     * 通过字段名和字段值获取BaseEnum实例
     *
     * @param targetClass 目标类型
     * @param fieldName   字段名
     * @param value       字段值
     * @return BaseEnum或null
     */
    private BaseEnum getEnum(Class<?> targetClass, String fieldName, String value) {
        Field field = ReflectUtil.getField(targetClass, fieldName);
        Class<?> fieldTypeClass = field.getType();
        // 获取所有枚举字段常量
        Object[] enumConstants = fieldTypeClass.getEnumConstants();
        for (Object enumConstant : enumConstants) {
            if (ClassUtil.isAssignable(BaseEnum.class, fieldTypeClass)) {
                BaseEnum baseEnum = (BaseEnum) enumConstant;
                if (Objects.equals(Convert.toStr(baseEnum.getValue()), Convert.toStr(value))) {
                    return baseEnum;
                }
            }
        }
        return null;
    }
}
