package com.codersinvasion.country.domain.repository

import com.codersinvasion.db.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

interface CountryRepository {

    suspend fun listCountriesFromRemoteThenInsertInLocal()
    fun getCountriesFlow() : Flow<List<CountryEntity>>
}