package com.codersinvasion.country.data.source.local

import com.codersinvasion.db.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

interface CountryLocalDataSource {
    suspend fun addCountryToLocal(countryEntity: CountryEntity)
    suspend fun addCountriesToLocal(countries: List<CountryEntity>)
    suspend fun listCountriesFromLocal() : List<CountryEntity>
    fun listCountriesFlowFromLocal() : Flow<List<CountryEntity>>
}