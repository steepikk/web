plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "webserver"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.json:json:20231013")
    implementation(files("libs/fastcgi-lib.jar"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("ru.itmo.Main")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    archiveBaseName.set("server")
    archiveClassifier.set("")
    archiveVersion.set(version.toString())

    manifest {
        attributes(
            "Main-Class" to "webserver.Main"
        )
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}
