package com.codersinvasion.authentication.data.repository

import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.data.model.response.TokenResponse
import com.codersinvasion.authentication.data.source.FakeLoginRemoteDatasource
import com.codersinvasion.authentication.domain.repository.LoginRepository
import com.codersinvasion.utils.resource.Resource

class FakeLoginRepository(
    private val fakeLoginRemoteDatasource: FakeLoginRemoteDatasource
) : LoginRepository {

    override suspend fun login(loginRequest: LoginRequest): Resource<TokenResponse> {
        return fakeLoginRemoteDatasource.login(loginRequest)
    }

}