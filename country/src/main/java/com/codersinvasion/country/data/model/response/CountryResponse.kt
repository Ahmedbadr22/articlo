package com.codersinvasion.country.data.model.response

import com.google.gson.annotations.SerializedName

data class CountryResponse(
    val id: Int,
    val name: String,
    val abbreviation: String,
    @SerializedName("flag")
    val flagPath: String,
)
