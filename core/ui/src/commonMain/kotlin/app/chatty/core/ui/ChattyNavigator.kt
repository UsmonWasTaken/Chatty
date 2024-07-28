@file:Suppress("NOTHING_TO_INLINE")

package app.chatty.core.ui

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition

@Composable
inline fun ChattyNavigator(initialScreen: Screen) {
    Navigator(screen = initialScreen) { navigator ->
        SlideTransition(
            navigator = navigator,
            disposeScreenAfterTransitionEnd = true,
        )
    }
}