package app.chatty.feature.overview.impl.overview

import androidx.compose.runtime.Composable
import app.chatty.feature.overview.api.overview.OverviewScreenFactory
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey

fun OverviewScreenFactory(): OverviewScreenFactory = OverviewScreenFactory(::OverviewScreen)

internal class OverviewScreen : Screen {

    override val key: ScreenKey = "OverviewScreen"

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}
