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
import com.poklad.notesmvvm.utlits.EMAIL
import com.poklad.notesmvvm.utlits.PASSWORD
import com.poklad.notesmvvm.utlits.TYPE_FIREBASE
import com.poklad.notesmvvm.utlits.TYPE_ROOM
import com.poklad.notesmvvm.utlits.showToast

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
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }
        binding.btnFirebase.setOnClickListener {
            visibleViewForLogin()
            binding.btnLogin.setOnClickListener {
                val inputEmail = binding.inputEmail.text.toString()
                val inputPassword = binding.inputPass.text.toString()
                if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                    EMAIL = inputEmail
                    PASSWORD = inputPassword
                    startViewModel.initDatabase(TYPE_FIREBASE) {
                        APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
                    }
                } else {
                    showToast(getString(R.string.toast_wrong_emter))
                }
            }
        }
    }

    private fun visibleViewForLogin() {
        binding.inputEmail.visibility = View.VISIBLE
        binding.inputPass.visibility = View.VISIBLE
        binding.btnLogin.visibility = View.VISIBLE
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