package com.codersinvasion.articlo.ui.create_account.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codersinvasion.country.domain.model.CountryUiState
import com.codersinvasion.country.domain.usecases.GetCountriesFlowUseCase
import com.codersinvasion.country.domain.usecases.ListCountriesFromRemoteToLocalUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CreateAccountViewModel(
    getCountriesFlowUseCase: GetCountriesFlowUseCase,
    private val listCountriesFromRemoteToLocalUseCase: ListCountriesFromRemoteToLocalUseCase
) : ViewModel() {

    private val _countriesLiveData: MutableLiveData<List<CountryUiState>> = MutableLiveData(emptyList())
    val countriesLiveData: LiveData<List<CountryUiState>>
        get() = _countriesLiveData

    private var selectedCountryId = Int.MIN_VALUE

    init {
        viewModelScope.launch {
            getCountriesFlowUseCase().collectLatest { countriesList ->
                _countriesLiveData.value = countriesList
            }
        }
    }

    fun listCountries() {
        viewModelScope.launch {
            listCountriesFromRemoteToLocalUseCase()
        }
    }

    fun onCountrySelected(id: Int) {
        selectedCountryId = id
        _countriesLiveData.value = _countriesLiveData.value?.map { countryUiState ->
            countryUiState.copy(isSelected = id == countryUiState.country.id)
        }
    }
}