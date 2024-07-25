package app.chatty.shared.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

actual fun supportDynamicColor(): Boolean = false

@Composable
internal actual fun colorScheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
): ColorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
