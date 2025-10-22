package io.github.yibird.starter.extension.datapermission.core.model;

import java.util.Set;

/**
 * @Description 用户上下文
 * @Author zchengfeng
 * @Datetime 2025/4/29 09:50
 */
public class UserContext {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户对应角色上下文列表
     */
    private Set<RoleContext> roles;
    /**
     * 部门ID
     */
    private String deptId;

    public UserContext() {
    }

    public UserContext(String userId, Set<RoleContext> roles, String deptId) {
        this.userId = userId;
        this.roles = roles;
        this.deptId = deptId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<RoleContext> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleContext> roles) {
        this.roles = roles;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
