package app.chatty.shared.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun ChattyTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit,
) {
    val colorScheme = if (supportDynamicColor() && dynamicColor) {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        if (darkTheme) DarkColorScheme else LightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}

@ChecksSdkIntAtLeast(Build.VERSION_CODES.S)
actual fun supportDynamicColor(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S