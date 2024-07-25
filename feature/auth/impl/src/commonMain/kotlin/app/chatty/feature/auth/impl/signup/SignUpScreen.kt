package app.chatty.feature.auth.impl.signup

import androidx.compose.runtime.Composable
import app.chatty.feature.auth.api.signup.SignUpScreenFactory
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey

fun SignUpScreenFactory(): SignUpScreenFactory = SignUpScreenFactory(::SignUpScreen)

internal class SignUpScreen : Screen {

    override val key: ScreenKey = "SignUpScreen"

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}