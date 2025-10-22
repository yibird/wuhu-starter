plugins {
    id("java")
}

dependencies {
    api("org.redisson:redisson-spring-boot-starter")

}

tasks.test {
    useJUnitPlatform()
}