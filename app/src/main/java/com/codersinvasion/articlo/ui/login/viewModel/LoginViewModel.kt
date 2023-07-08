package com.codersinvasion.articlo.ui.login.viewModel

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codersinvasion.articlo.R
import com.codersinvasion.authentication.domain.model.uiState.LoginUiState
import com.codersinvasion.authentication.domain.usecases.LoginUsecase
import com.codersinvasion.utils.liveData.SingleLiveEvent
import com.codersinvasion.utils.network.FailureStatus
import com.codersinvasion.utils.resource.Resource
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUsecase,
    private val resources: Resources
) : ViewModel() {
    val loginUiState: MutableLiveData<LoginUiState> = MutableLiveData(LoginUiState("", ""))

    private val _isLoadingLiveData: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val isLoadingObserver: LiveData<Boolean>
        get() = _isLoadingLiveData

    fun login() = viewModelScope.launch {
        _isLoadingLiveData.value = true
        val resource = loginUseCase(loginUiState.value!!)
        if(resource is Resource.Success) {
            Log.d("LoginViewModel", "Success ${resource.data?.access}")
        } else {
            val failureStatus: FailureStatus = (resource as Resource.Failure).failureStatus
            handleFailureStatus(failureStatus)
        }
        _isLoadingLiveData.value = false
    }

    private fun handleFailureStatus(failureStatus: FailureStatus) {
        val mainError = when(failureStatus) {
            FailureStatus.EMPTY_EMAIL_OR_PASSWORD -> resources.getString(R.string.please_enter_all_required_fields)
            FailureStatus.UN_AUTHORIZED -> resources.getString(R.string.wrong_email_or_password)
            FailureStatus.INVALID_EMAIL -> resources.getString(R.string.invalid_email_address)
            FailureStatus.INVALID_PASSWORD -> resources.getString(R.string.password_cant_be_less_than_6)
            FailureStatus.NO_INTERNET -> resources.getString(R.string.no_internet_connection)
            FailureStatus.BAD_REQUEST -> resources.getString(R.string.wrong_email_or_password)
            FailureStatus.UN_KNOWN -> resources.getString(R.string.unknown_error)
            FailureStatus.NOT_FOUND -> resources.getString(R.string.server_error)
            FailureStatus.INTERNAL_ERROR -> resources.getString(R.string.server_error)
        }
        loginUiState.value = loginUiState.value!!.copy(mainError = mainError)
    }
}