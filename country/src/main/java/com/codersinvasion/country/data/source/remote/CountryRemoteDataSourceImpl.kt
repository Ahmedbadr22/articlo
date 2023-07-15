package com.codersinvasion.country.data.source.remote

import com.codersinvasion.country.data.clientService.CountryClientService
import com.codersinvasion.country.data.model.response.CountryResponse
import com.codersinvasion.utils.network.safeApiCall
import com.codersinvasion.utils.resource.Resource

class CountryRemoteDataSourceImpl(
    private val countryClientService: CountryClientService
) : CountryRemoteDataSource {

    override suspend fun listCountriesFromRemote(): Resource<List<CountryResponse>> = safeApiCall {
        countryClientService.listCountries()
    }

}