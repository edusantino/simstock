package com.santino.simstock.data

import com.santino.simstock.data.models.Company
import com.santino.simstock.data.utils.GeneratorCalc
import com.santino.simstock.datasource.CompanyDao

class HomeRepositoryImpl(
    private val companyDao: CompanyDao,
    private val generatorCalc: GeneratorCalc,
) : HomeRepository {
    override suspend fun initCompanyData() {
        val companiesDataList = generatorCalc.initCompanyValues()
        companyDao.insertAll(companiesDataList)
    }

    override suspend fun getAllCompanies() = companyDao.getLastCompaniesValues()

    override suspend fun updateCompaniesData() {
        val listCompanies = companyDao.getLastCompaniesValues()

        val newValues = mutableListOf<Company>()
        for (company in listCompanies) {
            val lastCompanyData = listCompanies.filter { it.code == company.code }.sortedBy { it.time }.last()

            newValues.add(
                generatorCalc.generateCompanyValues(lastCompanyData)
            )
        }
        companyDao.insertAll(
            newValues
        )
    }
}