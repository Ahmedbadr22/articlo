package com.codersinvasion.authentication.data.repository.login

import com.codersinvasion.authentication.data.dataSource.remote.login.LoginRemoteDatasource
import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.data.model.response.TokenResponse
import com.codersinvasion.authentication.domain.repository.LoginRepository
import com.codersinvasion.utils.resource.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class LoginRepositoryImpl(
    private val loginRemoteDatasource: LoginRemoteDatasource
) : LoginRepository {

    override suspend fun login(loginRequest: LoginRequest): Resource<TokenResponse>  {
        return withContext(Dispatchers.IO) {
            loginRemoteDatasource.login(loginRequest)
        }
    }

}