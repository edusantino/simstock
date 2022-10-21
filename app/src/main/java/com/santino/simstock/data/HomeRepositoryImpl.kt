package com.santino.simstock.data

import com.santino.simstock.data.models.Company
import com.santino.simstock.data.utils.GeneratorCalc
import com.santino.simstock.datasource.CompanyDao

class HomeRepositoryImpl(
    private val companyDao: CompanyDao,
    private val generatorCalc: GeneratorCalc,
) : HomeRepository {
    override suspend fun getAllCompanies() = companyDao.getCompanies()

    override suspend fun initCompaniesData() {
        val listData = generatorCalc.autoGenerateCompanyValues()
        companyDao.insertAll(
            listData
        )
    }

    override suspend fun updateCompaniesData(list: List<Company>) {
        TODO("Not yet implemented")
    }
}