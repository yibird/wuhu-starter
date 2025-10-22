plugins {
    id("java")
    id("java-library")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-json")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    api("org.babyfish.jimmer:jimmer-spring-boot-starter")
}

tasks.test {
    useJUnitPlatform()
}