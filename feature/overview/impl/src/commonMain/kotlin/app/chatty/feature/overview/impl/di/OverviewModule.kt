package app.chatty.feature.overview.impl.di

import app.chatty.feature.overview.impl.overview.OverviewScreenFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val OverviewModule = module {
    factoryOf(::OverviewScreenFactory)
}