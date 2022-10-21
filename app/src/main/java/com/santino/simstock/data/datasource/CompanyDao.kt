package com.santino.simstock.data.datasource

import androidx.room.*
import com.santino.simstock.data.models.Company

@Dao
interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(companies: List<Company>)

    @Transaction
    @Query("SELECT * FROM companies")
    suspend fun getCompanies(): List<Company>
}