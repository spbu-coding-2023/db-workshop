val neo4jDriverVersion: String by project

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Neo4j
    implementation("org.neo4j.driver", "neo4j-java-driver", neo4jDriverVersion)

    // Logging
    implementation("io.github.microutils", "kotlin-logging-jvm", "2.0.6")
    implementation("org.slf4j", "slf4j-simple", "1.7.29")
}

application {
    // Define the main class for the application.
    mainClass.set("me.vkutuev.dbsandbox.Neo4jAppKt")
}
