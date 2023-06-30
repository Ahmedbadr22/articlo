package com.codersinvasion.authentication.data.extension

import com.codersinvasion.authentication.data.model.response.TokenResponse
import com.codersinvasion.authentication.domain.model.data.Token


fun TokenResponse.toToken() : Token = Token(access, refresh)