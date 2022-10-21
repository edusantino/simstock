package com.santino.simstock.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.santino.simstock.datasource.CompanyDao
import com.santino.simstock.data.models.Company

@Database(entities = [Company::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun companyDao(): CompanyDao
}
