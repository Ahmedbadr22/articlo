package com.codersinvasion.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codersinvasion.constants.DB

@Entity(tableName = DB.COUNTRY_TABLE)
data class CountryEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val abbreviation: String,
    val flagPath: String,
)