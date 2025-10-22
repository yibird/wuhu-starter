import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("java")
    id("jacoco")
    id("com.diffplug.spotless") version "7.0.4"
    id("org.sonarqube") version "6.2.0.5505"
    id("com.vanniktech.maven.publish") version "0.32.0"
}

val projectName = "Wuhu Start"
val artifactId = "wuhu-starter"
val projectGroup = "io.github.yibird"
val projectVersion = "0.0.34"
val projectDescription = "A high-quality starter collection based on springboot implementation"

description = projectDescription

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

allprojects {
    group = projectGroup
    version = projectVersion
    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        mavenCentral() {
            metadataSources {
                mavenPom()
                artifact()
            }
        }
    }
    tasks.withType<Javadoc>().configureEach {
        enabled = false
    }
    tasks.configureEach {
//        maxParallelForks = Runtime.getRuntime().availableProcessors()
    }
}
subprojects {
    apply {
        plugin("com.vanniktech.maven.publish")
        when {
            project.name == "wuhu-starter-dependencies" -> {
                plugin("java-platform") // BOM项目专用
            }

            else -> {
                plugin("java")          // 标准Java项目需要的基础插件
                plugin("java-library")  // 增强功能（api依赖配置等）
            }
        }
    }
    plugins.withType<JavaPlugin> {
        dependencies {
            implementation(platform(project(":wuhu-starter-dependencies")))
        }
    }
    configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
        signAllPublications()
        coordinates(projectGroup, project.name, projectVersion)
        pom { configureCommonPom(this@subprojects) }
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL);
    signAllPublications()
    coordinates(projectGroup, artifactId, projectVersion)

    pom { configureCommonPom(project, parent = true) }
}

// 代码格式化配置
spotless {
    java {
        // 使用 Google Java Format，并启用 AOSP 样式
        googleJavaFormat("1.17.0").aosp()
        // 移除未使用的 import
        removeUnusedImports()
        // 删除行尾多余的空格
        trimTrailingWhitespace()
        // 文件末尾添加换行符
        endWithNewline()
    }
}

// 代码质量配置
sonarqube {
    properties {
        property("sonar.gradle.skipCompile", "true")
        property("sonar.host.url", "http://localhost:9000")
        property("sonar.organization", "zchengfeng")
        property("sonar.projectKey", "zchengfeng_wuhu_starter")
        property("sonar.login", System.getenv("SONAR_TOKEN"))
        // 移除重复的配置
        property("sonar.projectName", projectName)
        property("sonar.projectVersion", projectVersion)
        property("sonar.sources", "src/main/java")
        property("sonar.tests", "src/test/java")
        property("sonar.java.binaries", "build/classes")
        property("sonar.sourceEncoding", "UTF-8")
    }
}

// 定义通用POM配置函数
fun MavenPom.configureCommonPom(project: Project, parent: Boolean = false) {
    val displayName = if (parent) "$projectName (Parent POM)" else project.name
    val displayDescription = if (parent)
        "Parent POM for $projectDescription"
    else "$projectDescription - Module ${project.name}"

    name.set(displayName)
    description.set(displayDescription)
    inceptionYear.set("2025")
    url.set("https://github.com/yibird/wuhu-starter")

    licenses {
        license {
            name.set("The Apache License, Version 2.0")
            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        }
    }

    developers {
        developer {
            id.set("yibird")
            name.set("zchengfeng")
            url.set("https://github.com/yibird")
        }
    }

    scm {
        url.set("https://github.com/yibird/wuhu-starter/")
        connection.set("scm:git:git://github.com/yibird/wuhu-starter.git")
        developerConnection.set("scm:git:ssh://git@github.com/yibird/wuhu-starter.git")
    }
}
