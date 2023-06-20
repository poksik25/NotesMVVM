package com.poklad.notesmvvm.utlits
import com.poklad.notesmvvm.MainActivity
import com.poklad.notesmvvm.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "TYPE_ROOM"
const val KEY_PARCELABLE_NOTES = "KEY_PARCELABLE_NOTES"
lateinit var REPOSITORY: DatabaseRepository
const val TYPE_FIREBASE = "TYPE_FIREBASE"
lateinit var EMAIL: String
lateinit var PASSWORD: String