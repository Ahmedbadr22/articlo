package com.codersinvasion.articlo.app.di

import com.codersinvasion.authentication.domain.usecases.LoginUsecase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::LoginUsecase)
}