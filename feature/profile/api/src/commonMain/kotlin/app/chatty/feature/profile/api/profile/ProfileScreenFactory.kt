package app.chatty.feature.profile.api.profile

import cafe.adriel.voyager.core.screen.Screen

fun interface ProfileScreenFactory {
    fun create(): Screen
}