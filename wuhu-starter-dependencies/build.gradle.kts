plugins {
    id("io.spring.dependency-management") version "1.1.7"
}

object Versions {
    const val sb = "3.5.3"
    const val snailJob = "1.2.0"
    const val saToken = "1.44.0"
    const val justAuth = "1.16.7"
    const val justAuthSpringBootStarter = "1.4.0"
    const val myBatisPlus = "3.5.8"
    const val myBatisFlex = "1.11.0"
    const val dynamicDatasource = "4.3.1"
    const val p6spy = "3.9.1"
    const val jetCache = "2.7.8"
    const val redisson = "3.49.0"
    const val cosid = "2.13.0"
    const val sms4j = "3.3.5"
    const val ajCaptcha = "1.3.0"
    const val easyCaptcha = "1.6.2"
    const val nashorn = "15.6"
    const val fastExcel = "1.2.0"
    const val awsSdk = "2.29.23"
    const val awsCrt = "0.33.5"
    const val thumbnailator = "0.4.20"
    const val gracefulResponse = "5.0.5-boot3"
    const val crane4j = "2.9.0"
    const val knife4j = "4.5.0"
    const val tlogWebSpringBootStarter = "1.5.2"
    const val snakeYaml = "2.4"
    const val okhttp = "4.12.0"
    const val ttl = "2.14.5"
    const val ip2region = "3.2.12"
    const val hutool = "5.8.39"
    const val commonsPool2 = "2.12.1"
    const val jimmer = "0.9.100"
    const val mapstruct = "1.6.3"
    const val caffeine = "3.2.2"
}

javaPlatform {
    allowDependencies()
}

dependencies {
    // 引入 Spring Boot 的 BOM 文件
    api(platform("org.springframework.boot:spring-boot-dependencies:${Versions.sb}"))

    // 定义其他依赖的版本约束
    constraints {
        api("com.aizuda:snail-job-client-starter:${Versions.snailJob}")
        api("cn.dev33:sa-token-spring-boot3-starter:${Versions.saToken}")
        api("me.zhyd.oauth:JustAuth:${Versions.justAuth}")
        api("com.xkcoding.justauth:justauth-spring-boot-starter:${Versions.justAuthSpringBootStarter}")
        api("com.baomidou:mybatis-plus-spring-boot3-starter:${Versions.myBatisPlus}")
        api("com.mybatis-flex:mybatis-flex-spring-boot3-starter:${Versions.myBatisFlex}")
        api("com.baomidou:dynamic-datasource-spring-boot3-starter:${Versions.dynamicDatasource}")
        api("p6spy:p6spy:${Versions.p6spy}")
        api("com.alicp.jetcache:jetcache-autoconfigure:${Versions.jetCache}")
        api("org.redisson:redisson-spring-boot-starter:${Versions.redisson}")
        api("me.ahoo.cosid:cosid-spring-boot-starter:${Versions.cosid}")
        api("org.dromara.sms4j:sms4j-spring-boot-starter:${Versions.sms4j}")
        api("com.anji-plus:captcha:${Versions.ajCaptcha}")
        api("com.github.whvcse:easy-captcha:${Versions.easyCaptcha}")
        api("org.openjdk.nashorn:nashorn-core:${Versions.nashorn}")
        api("cn.idev.excel:fastexcel:${Versions.fastExcel}")
        api("software.amazon.awssdk:s3:${Versions.awsSdk}")
        api("net.coobird:thumbnailator:${Versions.thumbnailator}")
        api("com.feiniaojin:graceful-response:${Versions.gracefulResponse}")
        api("cn.crane4j:crane4j-spring-boot-starter:${Versions.crane4j}")
        api("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:${Versions.knife4j}")
        api("com.yomahub:tlog-web-spring-boot-starter:${Versions.tlogWebSpringBootStarter}")
        api("org.yaml:snakeyaml:${Versions.snakeYaml}")
        api("com.squareup.okhttp3:okhttp:${Versions.okhttp}")
        api("com.alibaba:transmittable-thread-local:${Versions.ttl}")
        api("net.dreamlu:mica-ip2region:${Versions.ip2region}")
        api("cn.hutool:hutool-all:${Versions.hutool}")
        api("cn.hutool:hutool-core:${Versions.hutool}")
        api("cn.hutool:hutool-http:${Versions.hutool}")
        api("cn.hutool:hutool-extra:${Versions.hutool}")
        api("cn.hutool:hutool-crypto:${Versions.hutool}")
        api("org.apache.commons:commons-pool2:${Versions.commonsPool2}")
        api("org.babyfish.jimmer:jimmer-spring-boot-starter:${Versions.jimmer}")
        api("org.mapstruct:mapstruct:${Versions.mapstruct}")
        api("com.github.ben-manes.caffeine:caffeine:${Versions.caffeine}")
    }
}