plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    androidTarget()
    jvm()
    jvmToolchain(11)
    sourceSets {
        all {
            languageSettings.optIn("kotlinx.serialization.ExperimentalSerializationApi")
        }
        commonMain.dependencies {
            implementation(projects.core.common)
            implementation(projects.core.domain)

            api(libs.koin.core)
            api(libs.androidx.datastore.core)
            implementation(libs.androidx.datastore)
        }
    }
}

android {
    namespace = "app.chatty.core.datastore"
    compileSdk = 34
    defaultConfig.minSdk = 21
}