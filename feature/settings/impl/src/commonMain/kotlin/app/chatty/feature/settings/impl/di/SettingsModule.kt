package app.chatty.feature.settings.impl.di

import app.chatty.feature.settings.impl.settings.SettingsScreenFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val SettingsModule = module {
    factoryOf(::SettingsScreenFactory)
}