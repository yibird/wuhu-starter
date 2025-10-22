package io.github.yibird.annotation;

import java.lang.annotation.*;

/**
 * @Description 日志注解, 用于接口方法或类上
 * @Author zchengfeng
 * @Datetime 2025/4/11 14:09
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    /**
     * 日志描述
     */
    String value() default "";

    /**
     * 日志模块
     */
    String module() default "";

    /**
     * 是否忽略日志
     */
    boolean ignore() default false;
}
