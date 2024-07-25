package app.chatty.feature.profile.impl.di

import app.chatty.feature.profile.impl.profile.ProfileScreenFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val ProfileModule = module {
    factoryOf(::ProfileScreenFactory)
}