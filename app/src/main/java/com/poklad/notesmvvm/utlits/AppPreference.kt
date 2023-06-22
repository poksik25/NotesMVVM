package com.poklad.notesmvvm.utlits

import android.content.Context
import android.content.SharedPreferences

object AppPreference {
    private const val INIT_USER = "initUser"
    private const val TYPE_DB = "typeDB"
    private const val NAME_PREF = "preference"

    private lateinit var mPreferences: SharedPreferences

    fun getPreference(context: Context): SharedPreferences {
        mPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreferences
    }

    fun setInitUser(init: Boolean) {
        mPreferences.edit()
            .putBoolean(INIT_USER, init)
            .apply()
    }

    fun setTypeDb(type: String) {
        mPreferences.edit()
            .putString(TYPE_DB, type)
            .apply()
    }

    fun getInitUSer(): Boolean {
        return mPreferences.getBoolean(INIT_USER, false)
    }

    fun getTypeDB(): String {
        return mPreferences.getString(TYPE_DB, TYPE_ROOM).toString()
    }
}