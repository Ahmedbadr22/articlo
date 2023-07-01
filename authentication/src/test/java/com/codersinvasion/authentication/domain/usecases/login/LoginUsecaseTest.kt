package com.codersinvasion.authentication.domain.usecases.login

import com.codersinvasion.authentication.data.repository.FakeLoginRepository
import com.codersinvasion.authentication.data.source.FakeLoginRemoteDatasource
import com.codersinvasion.authentication.domain.model.uiState.LoginUiState
import com.codersinvasion.authentication.domain.usecases.LoginUsecase
import com.codersinvasion.utils.network.FailureStatus
import com.codersinvasion.utils.resource.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class LoginUsecaseTest {
    private lateinit var loginRepository: FakeLoginRepository
    private lateinit var loginUsecase: LoginUsecase

    @Before
    fun createUseCase() {
        val fakeLoginRemoteDatasource = FakeLoginRemoteDatasource()
        loginRepository = FakeLoginRepository(fakeLoginRemoteDatasource)
        loginUsecase = LoginUsecase(loginRepository)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun login_emptyEmail_assertFailureAndInvalidEmail() = runTest {
        val loginUiState = LoginUiState("", "123456789")
        val resource = loginUsecase(loginUiState)
        assert(resource is Resource.Failure)
        assertEquals(FailureStatus.INVALID_EMAIL, resource.failureStatus)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun login_emptyPassword_assertFailureAndInvalidPassword() = runTest {
        val loginUiState = LoginUiState("ahmed@gmail.com", "")
        val resource = loginUsecase(loginUiState)
        assert(resource is Resource.Failure)
        assertEquals(FailureStatus.INVALID_PASSWORD, resource.failureStatus)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun login_wrongEmail_assertFailureAndUnAuthorized() = runTest {
        val loginUiState = LoginUiState("mohamed@gmail.com", "123456789")
        val resource = loginUsecase(loginUiState)
        assert(resource is Resource.Failure)
        assertEquals(FailureStatus.UN_AUTHORIZED, resource.failureStatus)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun login_wrongPassword_assertFailureAndUnAuthorized() = runTest {
        val loginUiState = LoginUiState("ahmed@gmail.com", "12345")
        val resource = loginUsecase(loginUiState)
        assert(resource is Resource.Failure)
        assertEquals(FailureStatus.UN_AUTHORIZED, resource.failureStatus)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun login_existingUser_assertSuccessAndNotNull() = runTest {
        val loginUiState = LoginUiState("ahmed@gmail.com", "123456789")
        val resource = loginUsecase(loginUiState)
        assert(resource is Resource.Success)
        assert(resource.data != null)
    }
}