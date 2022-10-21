package com.santino.simstock.data.utils

enum class CompanyTypes(
    val compName: String,
    val code: String,
    val value: Double,
    val imgUrl: String,
    val valueGrowth: Double
) {
    McDonalds(
        "McDonald's",
        "MCDC",
        24.5,
        "https://pt.wikipedia.org/wiki/McDonald%27s#/media/Ficheiro:McDonald's_Golden_Arches.svg",
        0.0
    ),
    BurguerKing(
        "Burguer King",
        "BKB",
        10.5,
        "https://pt.wikipedia.org/wiki/Burger_King#/media/Ficheiro:Burger_King_2020.svg",
        0.0
    ),
}