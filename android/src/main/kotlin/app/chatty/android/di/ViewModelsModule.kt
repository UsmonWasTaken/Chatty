package app.chatty.android.di

import app.chatty.android.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val ViewModelsModule = module {
    viewModelOf(::MainViewModel)
}