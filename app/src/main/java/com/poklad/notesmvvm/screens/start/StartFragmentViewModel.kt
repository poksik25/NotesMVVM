package com.poklad.notesmvvm.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.poklad.notesmvvm.database.room.AppRoomDatabase
import com.poklad.notesmvvm.database.room.AppRoomRepository
import com.poklad.notesmvvm.utlits.REPOSITORY
import com.poklad.notesmvvm.utlits.TYPE_ROOM

class StartFragmentViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit /*todo*/) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}