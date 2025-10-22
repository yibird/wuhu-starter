package io.github.yibird.starter.extension.curd.core.handler;

import io.github.yibird.starter.extension.curd.core.annotation.CrudApi;

import java.lang.reflect.Method;

/**
 * @Description CrudApi前置处理器
 * @Author zchengfeng
 * @Datetime 2025/4/25 15:03
 */
public interface CrudApiHandler {

    void preHandle(CrudApi crudApi, Object[] args, Method targetMethod, Class<?> targetClass) throws Exception;
}
