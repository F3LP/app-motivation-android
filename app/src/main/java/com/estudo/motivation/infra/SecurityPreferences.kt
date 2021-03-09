package com.estudo.motivation.infra

import android.content.Context

class SecurityPreferences(context: Context) {

    private val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String = mSharedPreferences.getString(key, "") ?: ""
}