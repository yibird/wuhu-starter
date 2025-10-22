dependencies {
    api(project(":wuhu-starter-core"))
    implementation("org.springframework.boot:spring-boot-starter-websocket")
}

tasks.test {
    useJUnitPlatform()
}