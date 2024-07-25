package app.chatty.feature.auth.api.signin

import cafe.adriel.voyager.core.screen.Screen

fun interface SignInScreenFactory {
    fun create(): Screen
}