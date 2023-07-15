package com.codersinvasion.country.data.clientService

import com.codersinvasion.constants.API
import com.codersinvasion.country.data.model.response.CountryResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountryClientService {
    @GET(API.LIST_COUNTRIES)
    suspend fun listCountries() : Response<List<CountryResponse>>
}