plugins {
    id("java")
    id("java-library")
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    dependencies {
        implementation(project(":wuhu-starter-core"))
    }
}

tasks.test {
    useJUnitPlatform()
}