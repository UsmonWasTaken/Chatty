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
            implementation(projects.core.domain)
            implementation(projects.core.datastore)

            api(libs.koin.core)
        }
    }
}

android {
    namespace = "app.chatty.core.data"
    compileSdk = 34
    defaultConfig.minSdk = 21
}