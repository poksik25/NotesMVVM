package com.poklad.notesmvvm.utlits

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.poklad.notesmvvm.MainActivity
import com.poklad.notesmvvm.database.DatabaseRepository

lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_ID: String
lateinit var REF_DATABASE: DatabaseReference
lateinit var APP_ACTIVITY: MainActivity
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "TYPE_ROOM"
const val KEY_PARCELABLE_NOTES = "KEY_PARCELABLE_NOTES"
lateinit var REPOSITORY: DatabaseRepository
const val TYPE_FIREBASE = "TYPE_FIREBASE"
lateinit var EMAIL: String
lateinit var PASSWORD: String
const val ID_FIREBASE = "ID_FIREBASE"
const val NAME = "NAME"
const val TEXT = "TEXT"