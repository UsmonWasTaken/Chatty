package app.chatty.core.common.di

import app.chatty.core.common.platform.BaseSystemDirectories
import app.chatty.core.common.platform.LinuxBaseSystemDirectories
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val CommonPlatformModule: Module = module {
    // Note: The JVM implementation only works on Linux for now.
    singleOf(::LinuxBaseSystemDirectories).bind<BaseSystemDirectories>()
}