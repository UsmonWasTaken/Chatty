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
            implementation(projects.shared.designsystem)

            implementation(projects.feature.auth.impl)
            implementation(projects.feature.onboarding.impl)
            implementation(projects.feature.overview.impl)
            implementation(projects.feature.profile.impl)
            implementation(projects.feature.settings.impl)

            api(libs.koin.core)
            implementation(libs.koin.compose)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.material3)
        }

        androidMain.dependencies {
            api(libs.koin.android)
        }
    }
}

android {
    namespace = "app.chatty.shared.ui"
    compileSdk = 34
    defaultConfig.minSdk = 21
    buildFeatures.compose = true
}
