package app.chatty.feature.onboarding.impl.welcome

import androidx.compose.runtime.Composable
import app.chatty.feature.onboarding.api.welcome.WelcomeScreenFactory
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey

fun WelcomeScreenFactory(): WelcomeScreenFactory = WelcomeScreenFactory(::WelcomeScreen)

internal class WelcomeScreen : Screen {

    override val key: ScreenKey = "WelcomeScreen"

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}
