plugins {
    java
    id("com.gradleup.shadow") version "9.4.3"
}

group = "ru.ivancherepok"
version = "2.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.2.build.48-alpha")
    implementation("org.bstats:bstats-bukkit:3.2.1")
    implementation("net.dv8tion:JDA:5.6.1") {
        exclude(module = "opus-java")
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

tasks {
    withType<JavaCompile> {
        options.compilerArgs.add("-Xlint:deprecation")
    }

    jar {
        enabled = false
    }

    shadowJar {
        archiveBaseName.set("ForumAlert")
        archiveClassifier.set("")
        relocate("org.bstats", "${project.group}.bstats")
    }
    build {
        dependsOn(shadowJar)
    }
}
