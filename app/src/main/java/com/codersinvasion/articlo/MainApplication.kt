package com.codersinvasion.articlo

import android.app.Application
import com.codersinvasion.articlo.app.di.appModule
import com.codersinvasion.articlo.app.di.clientService
import com.codersinvasion.articlo.app.di.daoModule
import com.codersinvasion.articlo.app.di.dataSourceModule
import com.codersinvasion.articlo.app.di.repositoryModule
import com.codersinvasion.articlo.app.di.useCaseModule
import com.codersinvasion.articlo.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)

            modules(
                listOf(
                    appModule,
                    clientService,
                    daoModule,
                    dataSourceModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}