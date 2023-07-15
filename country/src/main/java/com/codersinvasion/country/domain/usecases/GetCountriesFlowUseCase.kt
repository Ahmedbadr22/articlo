package com.codersinvasion.country.domain.usecases

import com.codersinvasion.country.data.mappers.toCountryUiState
import com.codersinvasion.country.domain.model.CountryUiState
import com.codersinvasion.country.domain.repository.CountryRepository
import com.codersinvasion.db.entities.CountryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCountriesFlowUseCase(
    private val countryRepository: CountryRepository
) {
    operator fun invoke() : Flow<List<CountryUiState>> {
        return countryRepository.getCountriesFlow().map { countriesEntity ->
            countriesEntity.map(CountryEntity::toCountryUiState)
        }
    }
}