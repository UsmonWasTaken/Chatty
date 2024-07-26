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
            api(libs.koin.core)
        }
    }
}

android {
    namespace = "app.chatty.core.common"
    compileSdk = 34
    defaultConfig.minSdk = 21
}