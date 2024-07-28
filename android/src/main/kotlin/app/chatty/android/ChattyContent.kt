@file:Suppress("NOTHING_TO_INLINE")

package app.chatty.android

import androidx.compose.runtime.Composable
import app.chatty.core.designsystem.theme.ChattyTheme
import app.chatty.core.domain.model.ThemePreferences
import app.chatty.core.domain.model.UserPreferences
import app.chatty.core.ui.ChattyNavigator
import app.chatty.feature.onboarding.api.welcome.WelcomeScreenFactory
import app.chatty.feature.overview.api.overview.OverviewScreenFactory
import org.koin.compose.koinInject

@Composable
inline fun ChattyContent(
    themePreferences: ThemePreferences,
    userPreferences: UserPreferences,
) {
    ChattyTheme(
        darkTheme = themePreferences.darkMode,
        dynamicColor = themePreferences.dynamicColor,
    ) {
        val initialScreen = if (userPreferences.onboardingCompleted) {
            koinInject<OverviewScreenFactory>().create()
        } else {
            koinInject<WelcomeScreenFactory>().create()
        }
        ChattyNavigator(initialScreen = initialScreen)
    }
}
