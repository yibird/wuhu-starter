package io.github.yibird.starter.json.jackson.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description jackson JSON工具类
 * @Author zchengfeng
 * @Datetime 2025/4/2 0:26
 */
public class JSONUtils {
    /**
     * ObjectMapper实例
     */
    private static final ObjectMapper OBJECT_MAPPER = SpringUtil.getBean(ObjectMapper.class);

    /**
     * 获取ObjectMapper实例
     *
     * @return ObjectMapper实例
     */
    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    /**
     * 对象转JSON字符串
     *
     * @param object 对象
     * @return JSON字符串
     */
    public static String toJsonStr(Object object) {
        if (ObjectUtil.isNull(object)) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转JsonNode
     *
     * @param object 对象
     * @return JsonNode
     */
    public static JsonNode toJson(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.valueToTree(object);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * list转JsonNode
     *
     * @param list list
     * @return JsonNode
     */
    public static JsonNode listToJson(List<?> list) {
        return toJson(list);
    }

    /**
     * map转JsonNode
     *
     * @param map map
     * @return JsonNode
     */
    public static JsonNode mapToJson(Map<?, ?> map) {
        return toJson(map);
    }

    /**
     * JsonNode转List<String>
     *
     * @param jsonNode JsonNode
     * @return List<String>
     */
    public static List<String> jsonToStringList(JsonNode jsonNode) {
        if (jsonNode == null || jsonNode.isNull()) {
            return new ArrayList<>();
        }
        try {
            return OBJECT_MAPPER.convertValue(jsonNode, new TypeReference<>() {
            });
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * JsonNode 转换为指定类型的 Java 对象。
     *
     * @param jsonNode JSON 数据
     * @param clazz    目标 Java 类
     * @return 解析后的 Java 对象
     */
    public static <T> T fromJson(JsonNode jsonNode, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.treeToValue(jsonNode, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解析 JSON 字符串为 Java 对象。
     *
     * @param str   JSON 字符串
     * @param clazz 目标 Java 类
     * @return 解析后的 Java 对象
     */
    public static <T> T parseObject(String str, Class<T> clazz) {
        if (str == null || str.isBlank()) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(str, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 字符串 解析为 list<T>
     *
     * @param str   字符串
     * @param clazz 目标 Java 类
     * @return 解析后的 List<T>
     */
    public static <T> List<T> parseArray(String str, Class<T> clazz) {
        if (str == null || str.isBlank()) {
            return new ArrayList<>();
        }
        try {
            return OBJECT_MAPPER.readValue(str, OBJECT_MAPPER.getTypeFactory()
                    .constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断字符串是否为 JSON 格式。
     *
     * @param str 字符串
     * @return 是否为 JSON 格式
     */
    public static boolean isTypeJSON(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }
        try {
            OBJECT_MAPPER.readTree(str);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 将 JSON 字符串转换为指定类型的 Java 对象。
     *
     * @param str   字符串
     * @param clazz 目标对象的 Class 类型
     * @return 解析后的 Java 对象
     */
    public static <T> T toBean(String str, Class<T> clazz) {
        if (str == null || str.isBlank()) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(str, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
