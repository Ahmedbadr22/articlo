package com.codersinvasion.articlo.app.di

import com.codersinvasion.authentication.data.clientService.LoginClientService
import com.codersinvasion.country.data.clientService.CountryClientService
import org.koin.dsl.module
import retrofit2.Retrofit

val clientService = module {
    single {
        get<Retrofit>().create(LoginClientService::class.java)
    }

    single {
        get<Retrofit>().create(CountryClientService::class.java)
    }
}