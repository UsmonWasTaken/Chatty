import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose.compiler)
}

compose.desktop {
    application {
        mainClass = "app.chatty.desktop.Main"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "app.chatty.desktop"
            packageVersion = "1.0.0"
        }
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.designsystem)
    implementation(projects.core.ui)

    implementation(projects.feature.onboarding.api)
    implementation(projects.feature.overview.api)

    // To build dependency graph
    implementation(projects.core.data)
    implementation(projects.feature.onboarding.impl)
    implementation(projects.feature.overview.impl)

    implementation(libs.koin.core)
    implementation(libs.koin.compose)
    implementation(libs.voyager.core)
    implementation(compose.desktop.currentOs)
}