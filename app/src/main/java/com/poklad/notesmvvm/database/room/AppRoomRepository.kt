package com.poklad.notesmvvm.database.room

import androidx.lifecycle.LiveData
import com.poklad.notesmvvm.database.DatabaseRepository
import com.poklad.notesmvvm.model.AppNote

class AppRoomRepository(
    private val appRoomDao: AppRoomDao
) : DatabaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess()//todo зачем
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.deleteNote(note)
        onSuccess()
    }
}