plugins {
    id("java")
    id("java-library")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-configuration-processor")
    api("org.springframework.boot:spring-boot-starter-aop")
    api("net.dreamlu:mica-ip2region")
    api("cn.hutool:hutool-core")
    api("cn.hutool:hutool-http")
    api("cn.hutool:hutool-crypto")
    api("cn.hutool:hutool-extra")
}

tasks.withType<Javadoc>().configureEach {
    enabled = false
}