package io.github.yibird.starter.extension.datapermission.core.enums;

/**
 * @Description 数据权限枚举类
 * @Author zchengfeng
 * @Datetime 2025/4/29 09:43
 */
public enum DataScope {
    /**
     * 所有数据权限
     */
    ALL,
    /**
     * 本部门及其子部门数据权限
     */
    DEPT_AND_CHILD,
    /**
     * 部门数据权限
     */
    DEPT,
    /**
     * 当前用户数据权限
     */
    SELF,
    /**
     * 自定义数据权限
     */
    CUSTOM
}
