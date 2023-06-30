package com.codersinvasion.utils.resource

import com.codersinvasion.utils.network.FailureStatus

sealed class Resource<S> (
    val data: S? = null,
    val failureStatus: FailureStatus? = null,
) {
    class Success<S>(data: S?) : Resource<S>(data)
    class Failure<S>(error: FailureStatus) : Resource<S>( null, error)
    class Loading<S> : Resource<S>()
}
