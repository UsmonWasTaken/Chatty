@file:JvmName("Main")

package app.chatty.desktop

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.application
import app.chatty.core.data.di.DataModule
import app.chatty.core.domain.repository.ThemePreferencesRepository
import app.chatty.core.domain.repository.UserPreferencesRepository
import app.chatty.feature.onboarding.impl.di.OnboardingModule
import app.chatty.feature.overview.impl.di.OverviewModule
import org.koin.compose.KoinContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

fun main(args: Array<String>) {
    val koin = startKoin {
        modules(DataModule, OnboardingModule, OverviewModule)
        if (args.isDebuggableApp) printLogger(level = Level.DEBUG)
    }.koin

    val themePreferencesFlow = koin.get<ThemePreferencesRepository>().themePreferencesFlow
    val userPreferencesFlow = koin.get<UserPreferencesRepository>().userPreferencesFlow

    application {
        val themePreferences by themePreferencesFlow.collectAsState(initial = null)
        val userPreferences by userPreferencesFlow.collectAsState(initial = null)

        KoinContext(context = koin) {
            if (themePreferences != null && userPreferences != null) {
                ChattyWindow(
                    themePreferences = checkNotNull(themePreferences),
                    userPreferences = checkNotNull(userPreferences)
                )
            }
        }
    }
}

private val Array<String>.isDebuggableApp: Boolean
    inline get() = any { it.equals("debuggable", ignoreCase = true) }