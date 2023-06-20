package com.poklad.notesmvvm.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.poklad.notesmvvm.R
import com.poklad.notesmvvm.databinding.FragmentMainBinding
import com.poklad.notesmvvm.utlits.APP_ACTIVITY


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var mViewModel: MainFragmentViewModel /*by viewModels()*///todo чи краще через latenit?
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
        mViewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]//TODO може так?
        binding.flBtnAddNote.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }
}