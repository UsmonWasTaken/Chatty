package app.chatty.feature.onboarding.api.welcome

import cafe.adriel.voyager.core.screen.Screen

fun interface WelcomeScreenFactory {
    fun create(): Screen
}