package com.codersinvasion.authentication.domain.usecases

import com.codersinvasion.authentication.data.extension.toLoginRequest
import com.codersinvasion.authentication.data.extension.toToken
import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.data.model.response.TokenResponse
import com.codersinvasion.authentication.domain.model.uiState.LoginUiState
import com.codersinvasion.authentication.domain.model.data.Token
import com.codersinvasion.authentication.domain.repository.LoginRepository
import com.codersinvasion.utils.base.BaseIOUsecase
import com.codersinvasion.utils.network.FailureStatus
import com.codersinvasion.utils.resource.Resource
import com.codersinvasion.utils.resource.Validator
import com.codersinvasion.utils.validators.isValidEmail

class LoginUsecase(
  private val loginRepository: LoginRepository
) : BaseIOUsecase<LoginUiState, Resource<Token>> {

  override suspend fun invoke(input: LoginUiState): Resource<Token> {
    val validator: Validator = validateInput(input)

    if (validator is Validator.InValid) {
      return Resource.Failure(validator.failureStatus!!)
    }

    val loginRequest : LoginRequest = input.toLoginRequest()
    val resource = loginRepository.login(loginRequest)

    return if (resource is Resource.Success) {
      val tokenResponse: TokenResponse = resource.data!!
      Resource.Success(tokenResponse.toToken())
    } else {
      val failureStatus: FailureStatus = (resource as Resource.Failure).failureStatus
      Resource.Failure(failureStatus)
    }
  }

  override fun validateInput(input: LoginUiState): Validator {
    if (input.email.isEmpty() || !input.email.isValidEmail()) {
      return Validator.InValid(FailureStatus.INVALID_EMAIL)
    }

    if (input.password.isEmpty()) {
      return Validator.InValid(FailureStatus.INVALID_PASSWORD)
    }

    return Validator.Valid
  }


}