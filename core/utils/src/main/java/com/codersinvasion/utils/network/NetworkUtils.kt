package com.codersinvasion.utils.network

import android.util.Log
import com.codersinvasion.utils.resource.Resource
import retrofit2.Response

enum class FailureStatus {
    BAD_REQUEST,
    UN_AUTHORIZED,
    INTERNAL_ERROR,
    NO_INTERNET,
    UN_KNOWN,
    // Fields
    INVALID_EMAIL,
    INVALID_PASSWORD,
}

inline fun <reified T> safeApiCall(apiCall: () -> Response<T>): Resource<T> {
    return try {
        val apiResponse = apiCall.invoke() as Response<*>
        when (apiResponse.code()) {
            in 200..299 -> {
                val data = apiResponse.body() as T
                Resource.Success(data)
            }
            401 -> {
                Resource.Failure(FailureStatus.UN_AUTHORIZED)
            }
            400 -> {
                Resource.Failure(FailureStatus.BAD_REQUEST)
            }
            500 -> {
                Resource.Failure(FailureStatus.INTERNAL_ERROR)
            }
            else -> {
                Log.d("NetworkUtil", "${apiResponse.code()}")
                Resource.Failure(FailureStatus.UN_KNOWN)
            }
        }
    }
    catch (e: Exception){
        Log.d("NetworkUtils", "Error ==> ${e.message} | ${e.localizedMessage} | $e")
        Resource.Failure(FailureStatus.NO_INTERNET)
    }
}