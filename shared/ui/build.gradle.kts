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

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
        }
    }
}

android {
    namespace = "app.chatty.shared.ui"
    compileSdk = 34
    defaultConfig.minSdk = 21
    buildFeatures.compose = true
}
