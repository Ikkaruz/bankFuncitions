val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk18:$kotlin_version")
    implementation("io.ktor:ktor-server-cors-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("com.firebase:firebase-simple-login:1.4.2")
    implementation("com.firebase:firebase-token-generator:2.0.0")
    implementation("org.webjars.npm:firebase__auth:0.20.5")
    implementation("org.webjars.npm:firebase__firestore:3.4.12")
    implementation("com.google.firebase:firebase-admin:9.0.0")
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    implementation ("com.google.code.gson:gson:2.9.0")
    implementation("org.json:json:20220320")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
    implementation("io.ktor:ktor-serialization-gson-jvm:2.0.3")
    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

plugins {
    application
    kotlin("jvm") version "1.7.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
    id("io.ktor.plugin") version "2.1.2"
}

group = "com.banco"
version = "0.0.1"
application {
    mainClass.set("com.banco.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

tasks {
    create("stage").dependsOn("installDist")
}