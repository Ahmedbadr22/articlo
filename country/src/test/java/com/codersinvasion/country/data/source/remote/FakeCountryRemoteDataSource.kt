package com.codersinvasion.country.data.source.remote

import com.codersinvasion.country.data.model.response.CountryResponse
import com.codersinvasion.utils.network.FailureStatus
import com.codersinvasion.utils.resource.Resource
import kotlin.random.Random

class FakeCountryRemoteDataSource(
    private val countriesList : List<CountryResponse> = listOf(
        CountryResponse(1, "Egypt", "EG", "https://www.eg.com/flag"),
        CountryResponse(2, "United States Of America", "USA", "https://www.usa.com/flag"),
    )
) : CountryRemoteDataSource {

    override suspend fun listCountriesFromRemote(): Resource<List<CountryResponse>> {
        val isSuccess : Boolean = Random.nextBoolean()
//        return if (isSuccess) Resource.Success(countriesList)
//        else Resource.Failure(FailureStatus.INTERNAL_ERROR)

        return Resource.Success(countriesList)
    }
}