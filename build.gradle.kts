import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.4.10"

    java
    application
    kotlin("jvm") version kotlinVersion
    id("no.tornado.fxlauncher") version "1.0.20"
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

val controlsfxVersion = "8.40.17"
val tornadofxVersion = "1.7.20"

dependencies {

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0")
    implementation("no.tornado:tornadofx:$tornadofxVersion")
    implementation("org.controlsfx:controlsfx:$controlsfxVersion")
}

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

fxlauncher {
    applicationVendor = "My Company"
    applicationUrl = "http://fxldemo.tornado.no/"
    applicationMainClass = "no.tornado.FxlDemo"
    acceptDowngrade = false
}
