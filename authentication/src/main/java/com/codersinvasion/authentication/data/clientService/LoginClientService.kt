package com.codersinvasion.authentication.data.clientService

import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.data.model.response.TokenResponse
import com.codersinvasion.constants.API
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginClientService {
    @POST(API.LOGIN)
    suspend fun login(@Body loginRequest: LoginRequest) : Response<TokenResponse>
}