package com.codersinvasion.authentication.data.dataSource.remote.login

import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.data.model.response.TokenResponse
import com.codersinvasion.utils.resource.Resource

interface LoginRemoteDatasource {
    suspend fun login(loginRequest: LoginRequest) : Resource<TokenResponse>
}