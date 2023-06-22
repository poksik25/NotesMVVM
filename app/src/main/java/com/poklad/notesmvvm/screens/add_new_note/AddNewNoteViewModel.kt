package com.poklad.notesmvvm.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.poklad.notesmvvm.model.AppNote
import com.poklad.notesmvvm.utlits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteViewModel(
    application: Application
) : AndroidViewModel(application) {

    fun insert(note: AppNote, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) { //а приложение не падает?)
            REPOSITORY.insert(note) {
                onSuccess()
            }
        }
}
