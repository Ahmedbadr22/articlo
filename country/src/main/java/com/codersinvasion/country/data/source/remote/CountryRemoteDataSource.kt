package com.codersinvasion.country.data.source.remote

import com.codersinvasion.country.data.model.response.CountryResponse
import com.codersinvasion.utils.resource.Resource

interface CountryRemoteDataSource {
    suspend fun listCountriesFromRemote() : Resource<List<CountryResponse>>
}