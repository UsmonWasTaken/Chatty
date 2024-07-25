package app.chatty.shared.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.chatty.shared.designsystem.theme.ChattyTheme

@Composable
fun ContentView() {
    ChattyTheme {
        Scaffold {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                Text(text = "Hi, Mom!")
            }
        }
    }
}