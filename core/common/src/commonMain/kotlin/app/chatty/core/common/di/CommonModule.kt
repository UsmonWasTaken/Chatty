package app.chatty.core.common.di

import org.koin.core.module.Module
import org.koin.dsl.module

val CommonModule = module {
    includes(CommonPlatformModule)
}

expect val CommonPlatformModule: Module