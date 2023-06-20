package com.poklad.notesmvvm.screens.note
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poklad.notesmvvm.model.AppNote
import com.poklad.notesmvvm.utlits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel : ViewModel() {

    fun delete(note: AppNote, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.delete(note) {
                onSuccess()
            }
        }
    }
}