package app.chatty.feature.auth.impl.di

import app.chatty.feature.auth.impl.signin.SignInScreenFactory
import app.chatty.feature.auth.impl.signup.SignUpScreenFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val AuthModule = module {
    factoryOf(::SignInScreenFactory)
    factoryOf(::SignUpScreenFactory)
}