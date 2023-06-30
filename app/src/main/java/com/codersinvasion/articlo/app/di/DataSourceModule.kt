package com.codersinvasion.articlo.app.di

import com.codersinvasion.authentication.data.dataSource.remote.login.LoginRemoteDatasource
import com.codersinvasion.authentication.data.dataSource.remote.login.LoginRemoteDatasourceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataSourceModule = module {
    singleOf(::LoginRemoteDatasourceImpl) { bind<LoginRemoteDatasource>()}
}