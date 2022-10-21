package com.santino.simstock.data.utils

import com.santino.simstock.data.models.Company
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random


class GeneratorCalc {

    private var valueGrowth = 0.0

    fun generateCompanyValues(company: Company): Company {
        return Company(
            code = company.code,
            compName = company.compName,
            value = computeNewValue(company.value),
            valueGrowth = valueGrowth,
            imgURL = company.imgURL,
            time = getTime(),
            date = getDate(),
        )
    }

    fun initCompanyValues(): List<Company> {
        val list: ArrayList<Company> = arrayListOf()

        for (item in CompanyTypes.values()) {
            list.add(
                Company(
                    compName = item.compName,
                    code = item.code,
                    value = computeRandomValues(),
                    valueGrowth = computeRandomValueGrowth(),
                    imgURL = item.imgUrl,
                    date = getDate(),
                    time = getTime()
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

    private fun computeNewValue(companyValue: Double): Double {
        valueGrowth = Random.nextDouble(-5.5, 5.5)
        return ((companyValue * valueGrowth) / 100) + companyValue
    }

    private fun getTime(): String {
        return SimpleDateFormat("HH:mm:ss").format(Date())
    }

    private fun getDate(): String {
        return SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().time)
    }
}