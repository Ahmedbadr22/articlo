package com.codersinvasion.country.data.source.local

import com.codersinvasion.db.dao.CountryDao
import com.codersinvasion.db.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

class CountryLocalDataSourceImpl(
    private val countryDao: CountryDao
) : CountryLocalDataSource {
    override suspend fun addCountryToLocal(countryEntity: CountryEntity) {
        countryDao.insertCountry(countryEntity)
    }

    override suspend fun addCountriesToLocal(countries: List<CountryEntity>) {
        countryDao.insertCountries(countries)
    }

    override suspend fun listCountriesFromLocal(): List<CountryEntity> = countryDao.listCountries()

    override fun listCountriesFlowFromLocal(): Flow<List<CountryEntity>> = countryDao.listCountriesFlow()
}