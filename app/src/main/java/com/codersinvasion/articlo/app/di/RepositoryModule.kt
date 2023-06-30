package com.codersinvasion.articlo.app.di

import com.codersinvasion.authentication.data.repository.login.LoginRepositoryImpl
import com.codersinvasion.authentication.domain.repository.LoginRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::LoginRepositoryImpl) { bind<LoginRepository>() }
}