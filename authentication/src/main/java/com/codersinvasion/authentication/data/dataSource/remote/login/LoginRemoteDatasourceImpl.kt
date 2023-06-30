package com.codersinvasion.authentication.data.dataSource.remote.login

import com.codersinvasion.authentication.data.clientService.LoginClientService
import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.data.model.response.TokenResponse
import com.codersinvasion.utils.network.safeApiCall
import com.codersinvasion.utils.resource.Resource

class LoginRemoteDatasourceImpl(
    private val loginClientService: LoginClientService,
) : LoginRemoteDatasource {
    override suspend fun login(loginRequest: LoginRequest): Resource<TokenResponse> = safeApiCall {
        loginClientService.login(loginRequest)
    }
}