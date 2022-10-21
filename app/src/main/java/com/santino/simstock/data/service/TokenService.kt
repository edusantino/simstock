package com.santino.simstock.data.service

import android.content.Context
import android.content.SharedPreferences

class TokenService(context: Context) {
    private val preferences: SharedPreferences =
        context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)

    fun saveFcmToken(token: String) {
        val editor = preferences.edit()
        editor.putString("fcmToken", token)
        editor.apply()
    }

    fun getFcmToken(): String? {
        return preferences.getString("fcmToken", null)
    }

    fun isFirstAccess(): Boolean {
        return preferences.getBoolean("first_access", true)
    }

    fun setFirstAccess(firstAccess: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean("first_access", firstAccess)
        editor.apply()
    }
}