package com.example.homework3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.homework3.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var notificationStatus: Boolean = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE
        decorView.systemUiVisibility = uiOptions

        val navView: BottomNavigationView = binding.navView

        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment).navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_cab
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (notificationStatus) {
            menu?.findItem(R.id.notifications)?.isVisible = false
            menu?.findItem(R.id.notifications_on)?.isVisible = true
        } else {
            menu?.findItem(R.id.notifications)?.isVisible =true
            menu?.findItem(R.id.notifications_on)?.isVisible = false
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.notifications -> {
                notificationStatus = !notificationStatus
                Toast.makeText(this, "Notifications turned on!", Toast.LENGTH_SHORT).show()
                invalidateOptionsMenu()
            }
            R.id.notifications_on -> {
                notificationStatus = !notificationStatus
                Toast.makeText(this, "Notifications turned off!", Toast.LENGTH_SHORT).show()
                invalidateOptionsMenu()
            }
            R.id.day_theme -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Toast.makeText(this, "Day theme on!", Toast.LENGTH_SHORT).show()

            }
            R.id.night_theme -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                Toast.makeText(this, "Night theme on!", Toast.LENGTH_SHORT).show()

            }

        }

        return super.onOptionsItemSelected(item)
    }

}
