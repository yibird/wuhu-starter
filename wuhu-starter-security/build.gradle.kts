plugins {
    id("java")
}

dependencies {
    implementation(project(":wuhu-starter-web"))
}

tasks.test {
    useJUnitPlatform()
}