package app.chatty.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app.chatty.shared.ui.ContentView

fun main() {
    application {
        Window(
            title = "Chatty",
            onCloseRequest = ::exitApplication,
        ) {
            ContentView()
        }
    }
}
