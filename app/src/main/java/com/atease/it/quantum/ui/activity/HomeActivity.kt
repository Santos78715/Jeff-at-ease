package com.atease.it.quantum.ui.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.atease.it.quantum.R
import com.atease.it.quantum.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var binding: ActivityHomeBinding

    private lateinit var notification : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        notification = findViewById(R.id.notification)
        notification.setOnClickListener {
            navController.navigate(R.id.action_nav_home_to_notificationFragment)
        }


        navController.addOnDestinationChangedListener{ controller , destination, arguments ->
            if(destination.id==R.id.nav_home){
                toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_forward_ios_24)
            }
        }

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_vets_for_vets,
                R.id.nav_feed,
                R.id.nav_success_stories,
                R.id.nav_doante_now,
                R.id.nav_sponsors,
                R.id.nav_terms,
                R.id.nav_about_us,
                R.id.nav_privacy_policy
            ),
            binding.drawerLayout
        )

        binding.logout.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp(appBarConfiguration)
    }
}