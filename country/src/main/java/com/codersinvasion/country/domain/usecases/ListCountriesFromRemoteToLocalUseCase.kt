package com.codersinvasion.country.domain.usecases

import com.codersinvasion.country.domain.repository.CountryRepository

class ListCountriesFromRemoteToLocalUseCase(
    private val countryRepository: CountryRepository
) {

    suspend operator fun invoke() {
        countryRepository.listCountriesFromRemoteThenInsertInLocal()
    }
}