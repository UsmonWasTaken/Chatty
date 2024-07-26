import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose.compiler)
}

compose.desktop {
    application {
        mainClass = "app.chatty.desktop.MainKt"

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
    implementation(projects.core.designsystem)

    implementation(projects.core.data)
    implementation(projects.feature.onboarding.impl)

    implementation(libs.koin.core)
    implementation(libs.koin.compose)
    implementation(libs.voyager.navigator)
    implementation(libs.voyager.transitions)
    implementation(compose.desktop.currentOs)
}