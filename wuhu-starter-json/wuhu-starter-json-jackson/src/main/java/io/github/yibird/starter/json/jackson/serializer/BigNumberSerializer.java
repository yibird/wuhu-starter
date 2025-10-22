package io.github.yibird.starter.json.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;

import java.io.IOException;

/**
 * @Description 大数值序列化器
 * @Author zchengfeng
 * @Datetime 2025/4/2 0:27
 */
@JacksonStdImpl
public class BigNumberSerializer extends NumberSerializer {

    public static final BigNumberSerializer SERIALIZER_INSTANCE = new BigNumberSerializer(Number.class);

    /**
     * JS：Number.MAX_SAFE_INTEGER
     */
    private static final long MAX_SAFE_INTEGER = 9007199254740991L;
    /**
     * JS：Number.MIN_SAFE_INTEGER
     */
    private static final long MIN_SAFE_INTEGER = -9007199254740991L;

    public BigNumberSerializer(Class<? extends Number> rawType) {
        super(rawType);
    }

    @Override
    public void serialize(Number value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value.longValue() > MIN_SAFE_INTEGER && value.longValue() < MAX_SAFE_INTEGER) {
            super.serialize(value, gen, provider);
        } else {
            gen.writeString(value.toString());
        }
    }
}
