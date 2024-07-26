package app.chatty.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app.chatty.core.data.di.DataModule
import app.chatty.core.designsystem.theme.ChattyTheme
import app.chatty.feature.onboarding.api.welcome.WelcomeScreenFactory
import app.chatty.feature.onboarding.impl.di.OnboardingModule
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.koin.compose.koinInject
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@OptIn(ExperimentalVoyagerApi::class)
fun main(args: Array<String>) {
    startKoin {
        modules(DataModule, OnboardingModule)
        if (args.isDebuggableApp) printLogger(level = Level.DEBUG)
    }

    application {
        Window(
            title = "Chatty",
            onCloseRequest = ::exitApplication,
        ) {
            ChattyTheme {
                val welcomeScreen = koinInject<WelcomeScreenFactory>()
                Navigator(screen = welcomeScreen.create()) { navigator ->
                    SlideTransition(
                        navigator = navigator,
                        disposeScreenAfterTransitionEnd = true,
                    )
                }
            }
        }
    }
}

private val Array<String>.isDebuggableApp: Boolean
    inline get() = contains("debuggable")