package com.codersinvasion.authentication.data.source

import com.codersinvasion.authentication.data.dataSource.remote.login.LoginRemoteDatasource
import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.data.model.response.TokenResponse
import com.codersinvasion.utils.network.FailureStatus
import com.codersinvasion.utils.resource.Resource

class FakeLoginRemoteDatasource : LoginRemoteDatasource {

    override suspend fun login(loginRequest: LoginRequest): Resource<TokenResponse> {
        val email = "ahmed@gmail.com"
        val password = "123456789"

        return if (loginRequest.email == email && loginRequest.password == password) {
            val tokenResponse = TokenResponse("sadasdadsadada", "asdasasdsadasdsad")
            Resource.Success(tokenResponse)
        } else {
            Resource.Failure(FailureStatus.UN_AUTHORIZED)
        }
    }
}