package com.poklad.notesmvvm.screens.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.poklad.notesmvvm.R
import com.poklad.notesmvvm.databinding.FragmentNoteBinding
import com.poklad.notesmvvm.model.AppNote
import com.poklad.notesmvvm.utlits.APP_ACTIVITY
import com.poklad.notesmvvm.utlits.KEY_PARCELABLE_NOTES

class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var currentNote: AppNote
    private lateinit var mViewModel: NoteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable(KEY_PARCELABLE_NOTES) as AppNote
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this)[NoteFragmentViewModel::class.java]
        setHasOptionsMenu(true)
        binding.noteName.text = currentNote.name
        binding.noteText.text = currentNote.text
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_delete -> mViewModel.delete(currentNote) {
                APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}