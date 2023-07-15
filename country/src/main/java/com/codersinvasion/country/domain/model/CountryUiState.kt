package com.codersinvasion.country.domain.model


data class CountryUiState(
    val country: Country,
    var isSelected: Boolean = false
)
