package app.chatty.feature.auth.api.signup

import cafe.adriel.voyager.core.screen.Screen

fun interface SignUpScreenFactory {
    fun create(): Screen
}