package com.santino.simstock.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "companies")
data class Company(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    val compName: String,
    val code: String,
    val value: Double,
    val imgURL: String,
    val valueGrowth: Double,
    val date: String,
    val time: String,
)