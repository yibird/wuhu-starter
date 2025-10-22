plugins {
    id("java")
}

group = "io.github.yibird"
version = "0.0.31"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":wuhu-starter-web"))
    implementation(project(":wuhu-starter-cache:wuhu-starter-cache-redisson"))
    implementation(project(":wuhu-starter-extension:wuhu-starter-extension-crud:wuhu-starter-extension-crud-jimmer"))
    implementation(project(":wuhu-starter-auth:wuhu-starter-auth-satoken"))

    implementation("com.mysql:mysql-connector-j:8.4.0")

    compileOnly("org.mapstruct:mapstruct:1.6.3")
    compileOnly("org.projectlombok:lombok:1.18.38")
    compileOnly("org.babyfish.jimmer:jimmer-sql:0.9.90")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.babyfish.jimmer:jimmer-apt:0.9.90")
}
