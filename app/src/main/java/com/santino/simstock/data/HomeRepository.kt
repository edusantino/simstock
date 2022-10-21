package com.santino.simstock.data

import com.santino.simstock.data.models.Company

interface HomeRepository {
    suspend fun initCompanyData()
    suspend fun getAllCompanies(): List<Company>
    suspend fun updateCompaniesData()
}