plugins {
    id("java")
}

dependencies {
    implementation(project(":wuhu-starter-web"))
    implementation("com.yomahub:tlog-web-spring-boot-starter")
}

tasks.test {
    useJUnitPlatform()
}