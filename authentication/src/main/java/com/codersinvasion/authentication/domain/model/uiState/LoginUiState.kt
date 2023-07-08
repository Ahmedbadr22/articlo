package com.codersinvasion.authentication.domain.model.uiState


data class LoginUiState(
    var email: String,
    var password: String,
    var mainError: String = "",
)