package io.github.yibird.starter.extension.datapermission.core.model;

import io.github.yibird.starter.extension.datapermission.core.enums.DataScope;

/**
 * @Description 角色上下文类,数据权限与角色相关
 * @Author zchengfeng
 * @Datetime 2025/4/29 09:49
 */
public class RoleContext {
    /**
     * 角色 ID
     */
    private String roleId;

    /**
     * 数据权限
     */
    private DataScope dataScope;

    public RoleContext() {

    }

    public RoleContext(String roleId, DataScope dataScope) {
        this.roleId = roleId;
        this.dataScope = dataScope;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public DataScope getDataScope() {
        return dataScope;
    }

    public void setDataScope(DataScope dataScope) {
        this.dataScope = dataScope;
    }
}
