plugins {
    id("java")
}

dependencies {
   implementation(project(":wuhu-starter-web"))
   implementation(project(":wuhu-starter-cache:wuhu-starter-cache-redisson"))
}

tasks.test {
    useJUnitPlatform()
}