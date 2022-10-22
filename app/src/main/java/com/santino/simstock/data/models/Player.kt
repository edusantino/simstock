package com.santino.simstock.data.models

import androidx.room.Entity

@Entity(tableName = "user")
data class Player(
    val name: String,
    val totalWallet: Float = 10000.0f,
)