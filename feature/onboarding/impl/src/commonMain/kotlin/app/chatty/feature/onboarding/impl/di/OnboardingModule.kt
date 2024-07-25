package app.chatty.feature.onboarding.impl.di

import app.chatty.feature.onboarding.impl.welcome.WelcomeScreenFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val OnboardingModule = module {
    factoryOf(::WelcomeScreenFactory)
}