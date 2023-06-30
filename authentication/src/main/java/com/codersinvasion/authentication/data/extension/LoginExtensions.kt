package com.codersinvasion.authentication.data.extension

import com.codersinvasion.authentication.data.model.request.LoginRequest
import com.codersinvasion.authentication.domain.model.uiState.LoginUiState


fun LoginUiState.toLoginRequest() = LoginRequest(email, password)