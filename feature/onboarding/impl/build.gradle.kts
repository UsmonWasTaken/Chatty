plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose.compiler)
}

kotlin {
    androidTarget()
    jvm()
    jvmToolchain(11)
    sourceSets {
        commonMain.dependencies {
            api(projects.feature.onboarding.api)
        }
    }
}

android {
    namespace = "app.chatty.feature.onboarding.impl"
    compileSdk = 34
    defaultConfig.minSdk = 21
    buildFeatures.compose = true
}