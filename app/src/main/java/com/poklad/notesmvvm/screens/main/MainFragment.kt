package com.poklad.notesmvvm.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.poklad.notesmvvm.R
import com.poklad.notesmvvm.databinding.FragmentMainBinding
import com.poklad.notesmvvm.model.AppNote
import com.poklad.notesmvvm.utlits.APP_ACTIVITY
import com.poklad.notesmvvm.utlits.AppPreference
import com.poklad.notesmvvm.utlits.KEY_PARCELABLE_NOTES


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var mViewModel: MainFragmentViewModel
    private lateinit var recycleViewNotes: RecyclerView
    private lateinit var mainNoteAdapter: MainNoteAdapter
    private lateinit var observerList: Observer<List<AppNote>>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.note_action_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.btn_ext -> {
                        mViewModel.signOut()
                        AppPreference.setInitUser(false)
                        APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_startFragment)
                    }
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun initialization() {
        recycleViewNotes = binding.rvNotesList
        mainNoteAdapter = MainNoteAdapter()
        recycleViewNotes.adapter = mainNoteAdapter
        observerList = Observer {
            val list = it.asReversed()
            mainNoteAdapter.setList(list)
        }
        mViewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
        mViewModel.allNotes.observe(this, observerList)
        binding.flBtnAddNote.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.allNotes.removeObserver(observerList)
        recycleViewNotes.adapter = null
    }

    companion object {
        fun click(note: AppNote) {
            val bundle = Bundle()
            bundle.putSerializable(KEY_PARCELABLE_NOTES, note)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_noteFragment, bundle)
        }
    }
}