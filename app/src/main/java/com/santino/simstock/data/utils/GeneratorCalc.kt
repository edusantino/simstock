package com.santino.simstock.data.utils

import com.santino.simstock.data.models.Company
import kotlin.random.Random


class GeneratorCalc {
    fun generateCompanyValues(listCompanies: List<Company>): List<Company> {
        val list: ArrayList<Company> = arrayListOf()

        for (item in listCompanies) {
            //list.add(computeRandomValues(item))
        }
        return list
    }

    fun autoGenerateCompanyValues(): List<Company> {
        val list: ArrayList<Company> = arrayListOf()

        for (item in CompanyTypes.values()) {
            list.add(
                Company(
                    compName = item.compName,
                    code = item.code,
                    value = computeRandomValues(),
                    valueGrowth = item.valueGrowth,
                    imgURL = item.imgUrl
                )
            )
        }
        return list
    }

    private fun computeRandomValues(): Double {
        return Random.nextDouble(0.0, 10000.0)
    }

    private fun computeRandomValueGrowth(): Double {
        return Random.nextDouble(0.0, 5.5)
    }
}