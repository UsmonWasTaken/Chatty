plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose.compiler)
}

android {
    namespace = "app.chatty.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "app.chatty.android"
        minSdk = 21
        targetSdk = 35

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        resourceConfigurations += setOf("en")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs["debug"]
        }
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-dev"
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    packaging {
        resources {
            pickFirsts.add("META-INF/INDEX.LIST")
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.composeApp)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.splashscreen)
    implementation(compose.preview)
    debugImplementation(compose.uiTooling)
}
