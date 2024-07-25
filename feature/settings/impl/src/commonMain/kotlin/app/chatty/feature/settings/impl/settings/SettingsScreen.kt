package app.chatty.feature.settings.impl.settings

import androidx.compose.runtime.Composable
import app.chatty.feature.settings.api.settings.SettingsScreenFactory
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey

fun SettingsScreenFactory(): SettingsScreenFactory = SettingsScreenFactory(::SettingsScreen)

internal class SettingsScreen : Screen {

    override val key: ScreenKey = "SettingsScreen"

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}
