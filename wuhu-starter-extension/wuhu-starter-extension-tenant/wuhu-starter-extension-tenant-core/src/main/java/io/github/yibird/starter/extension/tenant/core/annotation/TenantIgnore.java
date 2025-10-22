package io.github.yibird.starter.extension.tenant.core.annotation;

import java.lang.annotation.*;

/**
 * @Description 多租户忽略注解
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:30
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TenantIgnore {
}