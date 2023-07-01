package com.codersinvasion.utils.resource

import com.codersinvasion.utils.network.FailureStatus

sealed class Resource<out T>  {
    data class Success<out T>(val data: T?) : Resource<T>()
    data class Failure(val failureStatus: FailureStatus) : Resource<Nothing>()
    object Loading: Resource<Nothing>()
}