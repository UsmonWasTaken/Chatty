package app.chatty.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app.chatty.shared.ui.ContentView
import app.chatty.shared.ui.di.UiModule
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

fun main(args: Array<String>) {
    val koinApplication = startKoin {
        modules(UiModule)
        if (args.isDebuggableApp) printLogger(level = Level.DEBUG)
    }

    application {
        Window(
            title = "Chatty",
            onCloseRequest = ::exitApplication,
        ) {
            ContentView(koin = koinApplication.koin)
        }
    }
}

private val Array<String>.isDebuggableApp: Boolean
    inline get() = contains("debuggable")