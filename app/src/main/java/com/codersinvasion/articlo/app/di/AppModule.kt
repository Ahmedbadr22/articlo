package com.codersinvasion.articlo.app.di



import android.app.Application
import androidx.room.Room
import com.codersinvasion.constants.API
import com.codersinvasion.constants.DB
import com.codersinvasion.db.AppDatabase
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {


    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(API.BASE_URL)
            .build()
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DB.NAME,
        ).build()
    }

    single {
        get<Application>().resources
    }
}