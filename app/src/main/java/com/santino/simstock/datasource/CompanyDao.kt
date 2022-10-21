package com.santino.simstock.datasource

import androidx.room.*
import com.santino.simstock.data.models.Company

@Dao
interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(companies: List<Company>)

    @Transaction
    @Query("SELECT * FROM companies")
    suspend fun getLastCompaniesValues(): List<Company>
}