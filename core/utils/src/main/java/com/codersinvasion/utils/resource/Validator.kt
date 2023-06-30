package com.codersinvasion.utils.resource

import com.codersinvasion.utils.network.FailureStatus

sealed class Validator(
    val failureStatus: FailureStatus? = null
) {
    object Valid : Validator()
    class InValid(failureStatus: FailureStatus) : Validator(failureStatus = failureStatus)
}
