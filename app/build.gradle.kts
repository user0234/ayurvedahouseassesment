plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.ayurvedahouseassesment"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.ayurvedahouseassesment"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}
//noinspection KaptUsageInsteadOfKsp UseTomlInstead
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Navigation Components
    val navigationComponent = "2.8.6"
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationComponent")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationComponent")

    //Dagger - Hilt

    val googleHiltVersion = "2.50"
    implementation("com.google.dagger:hilt-android:$googleHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$googleHiltVersion")

    val androidxHiltVersion = "1.2.0"
    kapt("androidx.hilt:hilt-compiler:$androidxHiltVersion")
    implementation("androidx.hilt:hilt-navigation-fragment:$androidxHiltVersion")

    // lifecycle and viewModel

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0") // Lifecycle

    val lifeCycleVersion = "2.8.7"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion")
    kapt("androidx.lifecycle:lifecycle-common-java8:$lifeCycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleVersion")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    // Room
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    val bumTech_version = "4.12.0"

    implementation("com.github.bumptech.glide:glide:$bumTech_version")  // Glide
    kapt("com.github.bumptech.glide:compiler:$bumTech_version")

}