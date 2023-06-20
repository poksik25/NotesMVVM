package com.poklad.notesmvvm.utlits

import com.poklad.notesmvvm.MainActivity
import com.poklad.notesmvvm.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_ROOM"
const val KEY_PARCELABLE_NOTES = "KEY_PARCELABLE_NOTES"
lateinit var REPOSITORY: DatabaseRepository