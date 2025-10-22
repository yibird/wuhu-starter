package io.github.yibird.starter.json.jackson.wrapper;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.type.ClassKey;

/**
 * @Description 反序列化器包装类（重写 Jackson 反序列化枚举方法，参阅：FasterXML/jackson-databind#2842）
 * @Author zchengfeng
 * @Datetime 2025/4/11 13:06
 */
public class SimpleDeserializersWrapper extends SimpleDeserializers {
    @Override
    public JsonDeserializer<?> findEnumDeserializer(Class<?> type,
                                                    DeserializationConfig config,
                                                    BeanDescription beanDesc) throws JsonMappingException {
        JsonDeserializer<?> deser = super.findEnumDeserializer(type, config, beanDesc);
        if (null != deser) {
            return deser;
        }
        // 重写增强：开始查找指定枚举类型的接口的反序列化器（例如：GenderEnum 枚举类型，则是找它的接口 BaseEnum 的反序列化器）
        for (Class<?> typeInterface : type.getInterfaces()) {
            deser = this._classMappings.get(new ClassKey(typeInterface));
            if (null != deser) {
                return deser;
            }
        }
        return null;
    }
}
