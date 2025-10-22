plugins {
    id("java")
}

dependencies {
    api(project(":wuhu-starter-extension:wuhu-starter-extension-tenant:wuhu-starter-extension-tenant-core"))
    api("com.baomidou:mybatis-plus-spring-boot3-starter")
}
