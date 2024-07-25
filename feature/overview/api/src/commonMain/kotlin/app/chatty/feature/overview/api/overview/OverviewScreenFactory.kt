package app.chatty.feature.overview.api.overview

import cafe.adriel.voyager.core.screen.Screen

fun interface OverviewScreenFactory {
    fun create(): Screen
}