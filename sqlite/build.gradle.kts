plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.8.10"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

val sqliteJdbcVersion: String by project

dependencies {
    // JDBC Sqlite
    implementation("org.xerial", "sqlite-jdbc", sqliteJdbcVersion)

    // Logging
    implementation("io.github.microutils", "kotlin-logging-jvm", "2.0.6")
    implementation("org.slf4j", "slf4j-simple", "1.7.29")
}

application {
    // Define the main class for the application.
    mainClass.set("me.vkutuev.dbsandbox.SqliteAppKt")
}
1