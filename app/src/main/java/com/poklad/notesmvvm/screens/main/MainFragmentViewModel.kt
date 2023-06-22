package com.poklad.notesmvvm.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.poklad.notesmvvm.utlits.REPOSITORY

class MainFragmentViewModel(
    application: Application
) : AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes

    fun signOut(){
        REPOSITORY.signOut()
    }
}