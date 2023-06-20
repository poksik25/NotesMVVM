package com.poklad.notesmvvm.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.poklad.notesmvvm.R
import com.poklad.notesmvvm.databinding.FragmentStartBinding
import com.poklad.notesmvvm.utlits.APP_ACTIVITY
import com.poklad.notesmvvm.utlits.TYPE_ROOM

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var startViewModel: StartFragmentViewModel
    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        startViewModel = ViewModelProvider(this)[StartFragmentViewModel::class.java]
        binding.btnRoom.setOnClickListener {
            startViewModel.initDatabase(TYPE_ROOM) {
                APP_ACTIVITY.mNavController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}