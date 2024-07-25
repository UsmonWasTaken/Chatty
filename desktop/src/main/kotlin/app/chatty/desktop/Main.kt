package app.chatty.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app.chatty.shared.ui.ContentView
import app.chatty.shared.ui.di.UiModule
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

fun main(args: Array<String>) {
    startKoin {
        modules(UiModule)
        if ("debug" in args) printLogger(level = Level.DEBUG)
    }

    application {
        Window(
            title = "Chatty",
            onCloseRequest = ::exitApplication,
        ) {
            ContentView()
        }
    }
}
