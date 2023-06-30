package com.codersinvasion.articlo.app.di

import com.codersinvasion.authentication.data.clientService.LoginClientService
import org.koin.dsl.module
import retrofit2.Retrofit

val clientService = module {
    single {
        get<Retrofit>().create(LoginClientService::class.java)
    }
}