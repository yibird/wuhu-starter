package io.github.yibird.starter.extension.curd.core.annotation;

import io.github.yibird.starter.extension.curd.core.enums.Api;

import java.lang.annotation.*;

/**
 * @Description crud请求映射注解
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:30
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CrudRequestMapping {
    /**
     * 路径映射 URI（等同于：@RequestMapping("/foo1")）
     */
    String value() default "";

    /**
     * API 列表
     */
    Api[] api() default {Api.Create, Api.Del, Api.Update, Api.List, Api.PageList, Api.Import, Api.Export};
}
