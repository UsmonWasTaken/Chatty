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
        all {
            languageSettings.optIn("cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi")
        }
        commonMain.dependencies {
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.transitions)

            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.runtime)
            implementation(compose.material3)
            implementation(compose.animation)
        }
    }
}

android {
    namespace = "app.chatty.core.ui"
    compileSdk = 34
    defaultConfig.minSdk = 21
}
