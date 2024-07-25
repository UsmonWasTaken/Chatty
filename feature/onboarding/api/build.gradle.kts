plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    androidTarget()
    jvm()
    jvmToolchain(11)
    sourceSets {
        commonMain.dependencies {
            api(libs.voyager.core)
        }
    }
}

android {
    namespace = "app.chatty.feature.onboarding.api"
    compileSdk = 34
    defaultConfig.minSdk = 21
}