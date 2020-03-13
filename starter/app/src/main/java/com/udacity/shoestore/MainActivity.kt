package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.whenCreated
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var activityViewModel: MainActivityViewModel
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = findNavController(R.id.myNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginFragment,
                R.id.welcomeFragment,
                R.id.instructionsFragment,
                R.id.shoesListFragment
            )
        )

        databinding.toolbar.setupWithNavController(navController, appBarConfiguration)

        activityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        activityViewModel.shoesList.observe(this, Observer {
            Timber.d("Activity debug")
        })

        activityViewModel.isOnBoardingCompleted.observe(this, Observer {

        })
        Timber.plant(Timber.DebugTree())
    }
}
