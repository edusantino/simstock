package com.santino.simstock.data.models

import androidx.room.Entity

@Entity(tableName = "user")
data class User(
    val totalWallet: Double,
)