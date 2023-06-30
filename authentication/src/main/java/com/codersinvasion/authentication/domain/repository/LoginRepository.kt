package com.codersinvasion.authentication.domain.repository

import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.data.model.response.TokenResponse
import com.codersinvasion.utils.resource.Resource

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest) : Resource<TokenResponse>
}