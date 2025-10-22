package io.github.yibird.starter.core.autoconfigure.project;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description 应用配置类
 * @Author zchengfeng
 * @Datetime 2025/3/18 2:41
 */
@ConfigurationProperties("project")
public class ProjectProperties {
    /**
     * 应用名称
     */
    private String name;
    /**
     * 版本号
     */
    private String version;
    /**
     * 应用描述
     */
    private String description;

    /**
     * 应用url
     */
    private String url;

    /**
     * 基本包
     */
    private String basePackage;
    /**
     * 联系人
     */
    private Contact contact;

    /**
     * 许可协议
     */
    private License license;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 是否为生产环境
     */
    private boolean production = false;

    /**
     * 联系人配置属性
     */
    public static class Contact {
        /**
         * 名称
         */
        private String name;

        /**
         * 邮箱
         */
        private String email;

        /**
         * URL
         */
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    /**
     * 许可协议配置属性
     */
    public static class License {
        /**
         * 名称
         */
        private String name;

        /**
         * URL
         */
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public boolean isProduction() {
        return production;
    }

    public void setProduction(boolean production) {
        this.production = production;
    }
}
