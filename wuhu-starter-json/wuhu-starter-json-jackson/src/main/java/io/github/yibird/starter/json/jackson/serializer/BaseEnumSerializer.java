package io.github.yibird.starter.json.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import io.github.yibird.starter.core.enums.BaseEnum;

import java.io.IOException;

/**
 * @Description 枚举接口 BaseEnum 序列化器
 * @Author zchengfeng
 * @Datetime 2025/4/11 12:58
 */
@JacksonStdImpl
public class BaseEnumSerializer extends JsonSerializer<BaseEnum> {

    public static final BaseEnumSerializer SERIALIZER_INSTANCE = new BaseEnumSerializer();

    @Override
    public void serialize(BaseEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(value.getValue());
    }
}
