package app.chatty.core.datastore.di

import app.chatty.core.common.di.CommonModule
import app.chatty.core.datastore.UserPreferencesDataStore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val DataStoreModule = module {
    includes(CommonModule)

    singleOf(::UserPreferencesDataStore)
}
