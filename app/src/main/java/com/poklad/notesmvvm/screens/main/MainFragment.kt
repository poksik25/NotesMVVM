package com.poklad.notesmvvm.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.poklad.notesmvvm.R
import com.poklad.notesmvvm.databinding.FragmentMainBinding
import com.poklad.notesmvvm.model.AppNote
import com.poklad.notesmvvm.utlits.APP_ACTIVITY
import com.poklad.notesmvvm.utlits.KEY_PARCELABLE_NOTES


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var mViewModel: MainFragmentViewModel /*by viewModels()*///todo чи краще через latenit?
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

    private fun initialization() {
        recycleViewNotes = binding.rvNotesList
        mainNoteAdapter = MainNoteAdapter()
        recycleViewNotes.adapter = mainNoteAdapter
        observerList = Observer {
            val list = it.asReversed()//переворот списка
            mainNoteAdapter.setList(list)
        }

        mViewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]//TODO може так?
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