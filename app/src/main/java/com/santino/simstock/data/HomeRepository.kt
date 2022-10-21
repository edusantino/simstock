package com.santino.simstock.data

import com.santino.simstock.data.models.Company

interface HomeRepository {
    suspend fun getAllCompanies(): List<Company>
    suspend fun initCompaniesData()
    suspend fun updateCompaniesData(list: List<Company>)
}