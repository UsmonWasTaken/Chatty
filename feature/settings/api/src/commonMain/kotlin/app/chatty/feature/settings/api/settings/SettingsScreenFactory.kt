package app.chatty.feature.settings.api.settings

import cafe.adriel.voyager.core.screen.Screen

fun interface SettingsScreenFactory {
    fun create(): Screen
}