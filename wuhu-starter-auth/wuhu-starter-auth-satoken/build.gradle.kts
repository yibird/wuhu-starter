plugins {
    id("java")
    id("java-library")
}

dependencies {
    implementation("cn.dev33:sa-token-spring-boot3-starter")
    implementation(project(":wuhu-starter-core"))
}

tasks.test {
    useJUnitPlatform()
}