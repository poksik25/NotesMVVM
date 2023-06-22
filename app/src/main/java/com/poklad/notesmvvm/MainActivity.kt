package com.poklad.notesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.poklad.notesmvvm.databinding.ActivityMainBinding
import com.poklad.notesmvvm.utlits.APP_ACTIVITY
import com.poklad.notesmvvm.utlits.AppPreference

class MainActivity : AppCompatActivity() {
    private lateinit var mToolbar: Toolbar
    lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APP_ACTIVITY =
            this                             //todo контекст из любого места в приложении. Так МОЖНО? - Нет, если тебе нужно во фрагменте иметь доступ к активети, ты можешь вызвать метод - requestActivity() или нулэймл поле activity
        mToolbar = binding.toolbar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)
        setSupportActionBar(mToolbar)
        title = getString(R.string.notes)

        AppPreference.getPreference(this)
    }
}
