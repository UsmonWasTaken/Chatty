plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose.compiler)
}

kotlin {
    androidTarget()
    jvm()
    sourceSets {
        commonMain.dependencies {
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.runtime)
            implementation(compose.material3)
        }
    }
    jvmToolchain(11)
}

android {
    namespace = "app.chatty.shared.designsystem"
    compileSdk = 34
    defaultConfig.minSdk = 21
}
