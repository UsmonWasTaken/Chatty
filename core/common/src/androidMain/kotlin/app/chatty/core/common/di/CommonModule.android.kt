package app.chatty.core.common.di

import app.chatty.core.common.platform.AndroidBaseSystemDirectories
import app.chatty.core.common.platform.BaseSystemDirectories
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val CommonPlatformModule: Module = module {
    singleOf(::AndroidBaseSystemDirectories).bind<BaseSystemDirectories>()
}