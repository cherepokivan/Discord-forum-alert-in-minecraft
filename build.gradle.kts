plugins {
    java
    id("com.gradleup.shadow") version "9.4.3"
}

group = "me.example"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")
    implementation("net.dv8tion:JDA:5.6.1") {
    exclude(module = "opus-java")
}
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

tasks {
    shadowJar {
        archiveClassifier.set("")
    }
    build {
        dependsOn(shadowJar)
    }
}
