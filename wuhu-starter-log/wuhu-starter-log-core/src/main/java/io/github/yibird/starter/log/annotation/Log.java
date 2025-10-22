package io.github.yibird.starter.log.annotation;

import java.lang.annotation.*;

/**
 * @Description 日志注解
 * @Author zchengfeng
 * @Datetime 2025/3/18 0:09
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    /**
     * 日志描述(仅用于方法上)
     */
    String value() default "";

    /**
     * 所属模块(用于接口方法或类)
     */
    String module() default "";
}
