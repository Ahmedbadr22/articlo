package com.codersinvasion.utils.base

import com.codersinvasion.utils.resource.Validator

interface BaseIOUsecase<I, O> {
    suspend operator fun invoke(input: I) : O
    fun validateInput(input: I) : Validator
}