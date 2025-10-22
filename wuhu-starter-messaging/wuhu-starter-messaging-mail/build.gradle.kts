plugins {
    id("java")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-mail")
}

tasks.test {
    useJUnitPlatform()
}