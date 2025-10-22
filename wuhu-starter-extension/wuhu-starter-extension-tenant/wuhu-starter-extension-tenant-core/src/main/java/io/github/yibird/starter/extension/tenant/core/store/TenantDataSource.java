package io.github.yibird.starter.extension.tenant.core.store;

/**
 * @Description 多租户数据源
 * @Author zchengfeng
 * @Datetime 2025/4/28 14:40
 */
public class TenantDataSource {
    /**
     * 连接池名称
     */
    private String poolName;

    /**
     * 驱动类名
     */
    private String driverClassName;

    /**
     * 数据库连接地址
     */
    private String url;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
