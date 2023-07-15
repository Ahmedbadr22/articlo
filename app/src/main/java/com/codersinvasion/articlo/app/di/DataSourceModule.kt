package com.codersinvasion.articlo.app.di

import com.codersinvasion.authentication.data.dataSource.remote.login.LoginRemoteDatasource
import com.codersinvasion.authentication.data.dataSource.remote.login.LoginRemoteDatasourceImpl
import com.codersinvasion.country.data.source.local.CountryLocalDataSource
import com.codersinvasion.country.data.source.local.CountryLocalDataSourceImpl
import com.codersinvasion.country.data.source.remote.CountryRemoteDataSource
import com.codersinvasion.country.data.source.remote.CountryRemoteDataSourceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataSourceModule = module {
    // Login
    singleOf(::LoginRemoteDatasourceImpl) { bind<LoginRemoteDatasource>()}

    // Country
    singleOf(::CountryRemoteDataSourceImpl) { bind<CountryRemoteDataSource>() }
    singleOf(::CountryLocalDataSourceImpl) { bind<CountryLocalDataSource>() }


}