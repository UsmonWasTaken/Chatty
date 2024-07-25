package app.chatty.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import app.chatty.core.designsystem.theme.ChattyTheme
import app.chatty.feature.onboarding.api.welcome.WelcomeScreenFactory
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.koin.compose.koinInject
import org.koin.core.context.stopKoin

@OptIn(ExperimentalVoyagerApi::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ChattyTheme {
                val welcomeScreen = koinInject<WelcomeScreenFactory>()
                Navigator(screen = welcomeScreen.create()) { navigator ->
                    SlideTransition(
                        navigator = navigator,
                        disposeScreenAfterTransitionEnd = true,
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!isChangingConfigurations) stopKoin()
    }
}
