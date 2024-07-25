package app.chatty.android

import android.app.Application
import android.content.pm.ApplicationInfo
import app.chatty.feature.onboarding.impl.di.OnboardingModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ChattyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(OnboardingModule)
            androidContext(applicationContext)
            if (isDebuggableApp) androidLogger(level = Level.DEBUG)
        }
    }
}

private val Application.isDebuggableApp: Boolean
    inline get() = (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0