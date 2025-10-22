plugins {
    id("java")
    id("java-library")
}

dependencies {
    api(project(":wuhu-starter-core"))
}

tasks.test {
    useJUnitPlatform()
}