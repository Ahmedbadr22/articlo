package com.codersinvasion.country.data.repository

import com.codersinvasion.country.data.mappers.toCountryEntity
import com.codersinvasion.country.data.model.response.CountryResponse
import com.codersinvasion.country.data.source.local.CountryLocalDataSource
import com.codersinvasion.country.data.source.remote.CountryRemoteDataSource
import com.codersinvasion.country.domain.repository.CountryRepository
import com.codersinvasion.db.entities.CountryEntity
import com.codersinvasion.utils.resource.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CountryRepositoryImpl(
    private val countryRemoteDataSource: CountryRemoteDataSource,
    private val countryLocalDataSource: CountryLocalDataSource,
) : CountryRepository {

    override suspend fun listCountriesFromRemoteThenInsertInLocal() {
        withContext(Dispatchers.IO) {
            val resources: Resource<List<CountryResponse>> = countryRemoteDataSource.listCountriesFromRemote()
            if (resources is Resource.Success) {
                val countriesEntity: List<CountryEntity> = resources.data?.map(CountryResponse::toCountryEntity) ?: emptyList()
                countryLocalDataSource.addCountriesToLocal(countriesEntity)
            }
        }
    }

    override fun getCountriesFlow(): Flow<List<CountryEntity>> = countryLocalDataSource.listCountriesFlowFromLocal()

}