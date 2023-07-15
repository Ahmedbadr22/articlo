package com.codersinvasion.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codersinvasion.constants.DB
import com.codersinvasion.db.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    /**
     * insert colorEntity instance of [countryEntity] Table into [DB.COUNTRY_TABLE]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(countryEntity: CountryEntity)

    /**
     * insert collection of [CountryEntity] Table into [DB.COUNTRY_TABLE]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<CountryEntity>)

    /**
     * @return [List] collection of [CountryEntity] Table
     */
    @Query("SELECT * FROM ${DB.COUNTRY_TABLE}")
    suspend fun listCountries() : List<CountryEntity>

    /**
     * @return [Flow] List collection of [CountryEntity] Table
     */
    @Query("SELECT * FROM ${DB.COUNTRY_TABLE}")
    fun listCountriesFlow() : Flow<List<CountryEntity>>
}