plugins {
    id("java")
    id("java-library")
}

dependencies {
    api("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter")
    implementation(project(":wuhu-starter-core"))
}

tasks.withType<Javadoc>().configureEach {
    enabled = false
}