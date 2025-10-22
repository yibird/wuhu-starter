package io.github.yibird.starter.extension.curd.core.annotation;

import io.github.yibird.starter.extension.curd.core.enums.Api;

/**
 * @Description crud注解
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:29
 */
public @interface CrudApi {
    // api类型
    Api value() default Api.List;
}
