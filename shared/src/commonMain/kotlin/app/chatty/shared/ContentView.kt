package app.chatty.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.chatty.shared.theme.ChattyTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ContentView() {
    ChattyTheme {
        Surface {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Hi, Mom!")
            }
        }
    }
}