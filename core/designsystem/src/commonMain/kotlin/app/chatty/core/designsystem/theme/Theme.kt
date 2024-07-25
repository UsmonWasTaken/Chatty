package app.chatty.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

internal val LightColorScheme = lightColorScheme()

internal val DarkColorScheme = darkColorScheme()

@Composable
internal expect fun colorScheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
): ColorScheme

expect fun supportDynamicColor(): Boolean

@Composable
fun ChattyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = supportDynamicColor(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = colorScheme(darkTheme, dynamicColor),
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}

@Composable
fun PreviewTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    ChattyTheme(darkTheme, dynamicColor) {
        Surface(content = content)
    }
}
