package io.github.yibird.starter.extension.datapermission.core.annotation;

import java.lang.annotation.*;

/**
 * @Description 数据权限注解类
 * @Author zchengfeng
 * @Datetime 2025/4/29 10:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataPermission {

    String id();

    /**
     * 表别名
     */
    String tableAlias();

    /**
     * 部门表别名
     */
    String deptTableAlias();

    /**
     * 部门id列名
     */
    String deptId();

    /**
     * 用户id列名
     */
    String userId();

    /**
     * 角色 ID（角色和部门关联表）
     */
    String roleId() default "role_id";

    /**
     * 角色和部门关联表别名
     */
    String roleDeptTableAlias() default "sys_role_dept";
}
