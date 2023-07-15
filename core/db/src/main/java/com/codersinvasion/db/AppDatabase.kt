package com.codersinvasion.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codersinvasion.db.dao.CountryDao
import com.codersinvasion.db.entities.CountryEntity

@Database(
    entities = [
        CountryEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCountryDao() : CountryDao
}