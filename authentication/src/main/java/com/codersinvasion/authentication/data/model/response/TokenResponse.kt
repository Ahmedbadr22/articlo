package com.codersinvasion.authentication.data.model.response

data class TokenResponse(
    val access: String,
    val refresh: String
)