
// Top-level build file where you can add configuration options common to all sub-projects/modules.

//noinspection UseTomlInstead
buildscript {
    val kotlin_version = "1.9.22"
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.6")
    }

}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version ("2.50") apply false
}