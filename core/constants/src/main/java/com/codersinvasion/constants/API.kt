package com.codersinvasion.constants

object API {
    const val BASE_URL : String = "https://b94e-102-43-13-143.ngrok-free.app"

    // Apps
    private const val AUTH_APP : String = "authentication"
    private const val COUNTRY_APP : String = "country"

    // Login
    const val LOGIN : String = "/$AUTH_APP/login"

    // Countries
    const val LIST_COUNTRIES = "/$COUNTRY_APP/list-countries"
}