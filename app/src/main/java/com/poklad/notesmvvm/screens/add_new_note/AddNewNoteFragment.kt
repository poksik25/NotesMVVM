package com.poklad.notesmvvm.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.poklad.notesmvvm.R
import com.poklad.notesmvvm.databinding.FragmentAddNewNoteBinding
import com.poklad.notesmvvm.model.AppNote
import com.poklad.notesmvvm.utlits.APP_ACTIVITY
import com.poklad.notesmvvm.utlits.showToast

class AddNewNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNewNoteBinding
    private lateinit var mViewModel: AddNewNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this)[AddNewNoteViewModel::class.java]
        binding.btnAddNote.setOnClickListener {
            validData()
        }
    }

    private fun validData() {
        val nameTxt = binding.etInputNameNote.text.toString()
        val textNote = binding.etInputTextNote.text.toString()
        if (nameTxt.isEmpty()) {
            showToast(getString(R.string.toast_enter_name))
        } else {
            mViewModel.insert(AppNote(name = nameTxt, text = textNote)) {
                APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
            }
        }
    }

}