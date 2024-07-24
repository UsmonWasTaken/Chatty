package app.chatty.shared.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

internal val LightColorScheme = lightColorScheme()

internal val DarkColorScheme = darkColorScheme()

@Composable
expect fun ChattyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = supportDynamicColor(),
    content: @Composable () -> Unit,
)

expect fun supportDynamicColor(): Boolean