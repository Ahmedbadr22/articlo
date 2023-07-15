package com.codersinvasion.country.data.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.codersinvasion.db.AppDatabase
import com.codersinvasion.db.dao.CountryDao
import com.codersinvasion.db.entities.CountryEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class CountryDaoTest {
    private lateinit var countryDao: CountryDao
    private lateinit var appDatabase: AppDatabase


    @Before
    fun setupDatabase() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        countryDao = appDatabase.getCountryDao()
    }

    @After
    fun closeDatabase() {
        appDatabase.close()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun insertCountry_assertNotEmpty() = runTest {
        val countryEntity = CountryEntity(1, "Egypt", "EG", "https://www.eg.com/flag")
        countryDao.insertCountry(countryEntity)

        val countriesEntity : List<CountryEntity> = countryDao.listCountries()
        assert(countriesEntity.isNotEmpty())
        assert(countriesEntity[0].id == 1)
        assertEquals("Egypt", countriesEntity[0].name)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun insertCountries_assertNotEmpty() = runTest {
        val countriesList : List<CountryEntity> = listOf(
            CountryEntity(1, "Egypt", "EG", "https://www.eg.com/flag"),
            CountryEntity(2, "United States Of America", "USA", "https://www.usa.com/flag"),
        )

        countryDao.insertCountries(countriesList)
        val countriesEntity : List<CountryEntity> = countryDao.listCountries()

        assert(countriesEntity.isNotEmpty())
        assertEquals(2, countriesEntity.size)
        assertEquals(1, countriesEntity[0].id)
        assertEquals(2, countriesEntity[1].id)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun listCountries_assertEmpty() = runTest {
        val countriesEntity : List<CountryEntity> = countryDao.listCountries()

        assert(countriesEntity.isEmpty())
        assertEquals(0, countriesEntity.size)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun listCountriesFlow_assertNotEmpty() = runTest {
        backgroundScope.launch(UnconfinedTestDispatcher()) {
            val country  = CountryEntity(1, "Egypt", "EG", "https://www.eg.com/flag")
            countryDao.insertCountry(country)

            val itemsCount = countryDao.listCountriesFlow().count()
            assertEquals(1, itemsCount)
        }
    }
}