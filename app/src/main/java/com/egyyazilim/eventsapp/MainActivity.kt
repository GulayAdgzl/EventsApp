package com.egyyazilim.eventsapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.egyyazilim.eventsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.navigate(R.id.navigation_splash)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_splash,
                R.id.navigation_home,
                R.id.navigation_dashboard
            )

            /*setOf(
                R.id.navigation_home, R.id.navigation_dashboard
            )*/

        )
        val noBottomNavigationIds = listOf(R.id.navigation_splash, R.id.navigation_dashboard)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (noBottomNavigationIds.contains(destination.id)) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
    }
}