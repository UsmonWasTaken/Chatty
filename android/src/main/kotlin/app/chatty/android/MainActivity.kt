package app.chatty.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.compose.KoinContext
import org.koin.core.context.stopKoin

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition(viewModel::shouldKeepSplashScreen)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val themePreferences by viewModel.themePreferencesFlow.collectAsState()
            val userPreferences by viewModel.userPreferencesFlow.collectAsState()
            KoinContext {
                if (themePreferences != null && userPreferences != null) {
                    ChattyContent(
                        themePreferences = checkNotNull(themePreferences),
                        userPreferences = checkNotNull(userPreferences)
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
