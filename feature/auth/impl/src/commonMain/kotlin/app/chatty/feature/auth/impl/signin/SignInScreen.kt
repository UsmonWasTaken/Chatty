package app.chatty.feature.auth.impl.signin

import androidx.compose.runtime.Composable
import app.chatty.feature.auth.api.signin.SignInScreenFactory
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey

fun SignInScreenFactory(): SignInScreenFactory = SignInScreenFactory(::SignInScreen)

internal class SignInScreen : Screen {

    override val key: ScreenKey = "SignInScreen"

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}