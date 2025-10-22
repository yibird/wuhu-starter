plugins {
    id("java")
    id("java-library")
}

configurations.all {
    exclude(group="org.springframework.boot", module="spring-boot-starter-tomcat")
}

dependencies {
    api(project(":wuhu-starter-core"))
    api(project(":wuhu-starter-api-doc"))
    api(project(":wuhu-starter-json:wuhu-starter-json-jackson"))

    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-undertow")
    api("com.feiniaojin:graceful-response")
    api("cn.dev33:sa-token-spring-boot3-starter")
}
