package com.codersinvasion.articlo.app.di

import com.codersinvasion.db.AppDatabase
import org.koin.dsl.module

val daoModule = module {
    single {
        get<AppDatabase>().getCountryDao()
    }
}