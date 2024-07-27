package app.chatty.core.data.di

import app.chatty.core.data.repository.DefaultThemePreferencesRepository
import app.chatty.core.data.repository.DefaultUserPreferencesRepository
import app.chatty.core.datastore.di.DataStoreModule
import app.chatty.core.domain.repository.ThemePreferencesRepository
import app.chatty.core.domain.repository.UserPreferencesRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val DataModule = module {
    includes(DataStoreModule)

    singleOf(::DefaultUserPreferencesRepository).bind<UserPreferencesRepository>()
    singleOf(::DefaultThemePreferencesRepository).bind<ThemePreferencesRepository>()
}