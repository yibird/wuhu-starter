plugins {
    id("java")
    id("java-library")
}

dependencies {
    // jetCache自动配置依赖
    implementation("com.alicp.jetcache:jetcache-autoconfigure")
    // jetCache注解依赖
    implementation("com.alicp.jetcache:jetcache-anno:2.7.7")
    // jetCache Redisson 适配依赖
    implementation("com.alicp.jetcache:jetcache-redisson:2.7.7")
    // 池化依赖
    implementation("org.apache.commons:commons-pool2")
    // wuhu-starter-cache-redisson
    implementation(project(":wuhu-starter-cache:wuhu-starter-cache-redisson"))

}

tasks.test {
    useJUnitPlatform()
}