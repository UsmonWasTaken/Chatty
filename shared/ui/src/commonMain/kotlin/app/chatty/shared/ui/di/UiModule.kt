package app.chatty.shared.ui.di

import app.chatty.feature.auth.impl.di.AuthModule
import app.chatty.feature.onboarding.impl.di.OnboardingModule
import app.chatty.feature.overview.impl.di.OverviewModule
import app.chatty.feature.profile.impl.di.ProfileModule
import app.chatty.feature.settings.impl.di.SettingsModule
import org.koin.dsl.module

val UiModule = module {
    includes(AuthModule)
    includes(OnboardingModule)
    includes(OverviewModule)
    includes(ProfileModule)
    includes(SettingsModule)
}