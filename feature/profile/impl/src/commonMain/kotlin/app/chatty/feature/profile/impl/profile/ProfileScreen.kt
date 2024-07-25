package app.chatty.feature.profile.impl.profile

import androidx.compose.runtime.Composable
import app.chatty.feature.profile.api.profile.ProfileScreenFactory
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey

fun ProfileScreenFactory(): ProfileScreenFactory = ProfileScreenFactory(::ProfileScreen)

internal class ProfileScreen : Screen {

    override val key: ScreenKey = "ProfileScreen"

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}
