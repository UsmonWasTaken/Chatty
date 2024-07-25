package app.chatty.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import app.chatty.shared.ui.ContentView
import org.koin.core.KoinApplication
import org.koin.core.context.stopKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContentView(koin = koinApplication.koin)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!isChangingConfigurations) stopKoin()
    }
}

private val MainActivity.koinApplication: KoinApplication
    inline get() = (application as ChattyApplication).koinApplication