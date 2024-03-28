plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.23"
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

val exposedVersion: String by project
val sqliteJdbcVersion: String by project
dependencies {
    // JetBrains Exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    // JDBC Sqlite
    implementation("org.xerial", "sqlite-jdbc", sqliteJdbcVersion)

    // Logging
    implementation("org.slf4j", "slf4j-simple", "1.7.29")
}

application {
    // Define the main class for the application.
    mainClass.set("me.vkutuev.dbsandbox.SqliteExposedAppKt")
}
