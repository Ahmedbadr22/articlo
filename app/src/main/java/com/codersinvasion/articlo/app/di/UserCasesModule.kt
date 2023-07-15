package com.codersinvasion.articlo.app.di

import com.codersinvasion.authentication.domain.usecases.LoginUsecase
import com.codersinvasion.country.domain.usecases.GetCountriesFlowUseCase
import com.codersinvasion.country.domain.usecases.ListCountriesFromRemoteToLocalUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::LoginUsecase)
    // Country
    singleOf(::ListCountriesFromRemoteToLocalUseCase)
    singleOf(::GetCountriesFlowUseCase)
}