package com.codersinvasion.country.data.mappers

import com.codersinvasion.db.entities.CountryEntity
import com.codersinvasion.country.data.model.response.CountryResponse
import com.codersinvasion.country.domain.model.Country
import com.codersinvasion.country.domain.model.CountryUiState


fun CountryEntity.toCountry() = Country(id, name, abbreviation, flagPath)
fun CountryEntity.toCountryUiState() = CountryUiState(Country(id, name, abbreviation, flagPath))
fun CountryResponse.toCountryEntity() = CountryEntity(id, name, abbreviation, flagPath)
