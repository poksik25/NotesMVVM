package com.poklad.notesmvvm.database.firebase

import androidx.lifecycle.LiveData
import com.poklad.notesmvvm.database.DatabaseRepository
import com.poklad.notesmvvm.model.AppNote

class AppFirebaseRepository:DatabaseRepository {

    override val allNotes: LiveData<List<AppNote>>
        get() = TODO("Not yet implemented")

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        super.connectToDatabase(onSuccess, onFail)
    }

    override fun signOut() {
        super.signOut()
    }
}