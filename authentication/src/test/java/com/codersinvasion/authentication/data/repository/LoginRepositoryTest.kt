package com.codersinvasion.authentication.data.repository

import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.data.repository.login.LoginRepositoryImpl
import com.codersinvasion.authentication.data.source.FakeLoginRemoteDatasource
import com.codersinvasion.authentication.domain.repository.LoginRepository
import com.codersinvasion.utils.network.FailureStatus
import com.codersinvasion.utils.resource.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class LoginRepositoryTest {

    private lateinit var loginRemoteDatasource: FakeLoginRemoteDatasource

    // class under test
    private lateinit var loginRepository: LoginRepository

    @Before
    fun createRepository() {
        loginRemoteDatasource = FakeLoginRemoteDatasource()
        loginRepository = LoginRepositoryImpl(loginRemoteDatasource)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun login_rightData_assertSuccess() = runTest {
        val email = "ahmed@gmail.com"
        val password = "123456789"

        val loginRequest = LoginRequest(email, password)

        val resource = loginRepository.login(loginRequest)
        if(resource is Resource.Success) assert(true)
        else assert(false)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun login_wrongData_assertFailure() = runTest {
        val email = "moahmed@gmail.com"
        val password = "12345"

        val loginRequest = LoginRequest(email, password)

        val resource = loginRepository.login(loginRequest)
        if(resource is Resource.Failure) {
            assert(true)
            assertEquals(resource.failureStatus, FailureStatus.UN_AUTHORIZED)
        } else {
            assert(false)
        }

    }
}