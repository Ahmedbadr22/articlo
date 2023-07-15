package com.codersinvasion.country.data.repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.codersinvasion.country.data.source.local.CountryLocalDataSource
import com.codersinvasion.country.data.source.local.CountryLocalDataSourceImpl
import com.codersinvasion.country.data.source.remote.CountryRemoteDataSource
import com.codersinvasion.country.data.source.remote.FakeCountryRemoteDataSource
import com.codersinvasion.country.domain.repository.CountryRepository
import com.codersinvasion.db.AppDatabase
import com.codersinvasion.db.dao.CountryDao
import com.codersinvasion.db.entities.CountryEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class CountryRepositoryTest {
    private lateinit var countryRemoteDataSource: CountryRemoteDataSource
    private lateinit var countryLocalDataSource: CountryLocalDataSource

    private lateinit var countryRepository: CountryRepository

    @Before
    fun createRepository() {
        countryRemoteDataSource = FakeCountryRemoteDataSource()
        val appDatabase : AppDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        val countryDao : CountryDao = appDatabase.getCountryDao()

        countryLocalDataSource = CountryLocalDataSourceImpl(countryDao)

        countryRepository = CountryRepositoryImpl(countryRemoteDataSource, countryLocalDataSource)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun listCountriesFromRemoteThenInsertInLocal_assertNotEmpty() = runTest {
        var localCountriesList: List<CountryEntity> = countryLocalDataSource.listCountriesFromLocal()
        assertEquals(0, localCountriesList.size)

        countryRepository.listCountriesFromRemoteThenInsertInLocal()

        localCountriesList = countryLocalDataSource.listCountriesFromLocal()
        assertEquals(2, localCountriesList.size)
    }
}
