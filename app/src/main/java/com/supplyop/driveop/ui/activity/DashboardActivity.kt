package com.supplyop.driveop.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ActivityDashboardBinding
import com.supplyop.driveop.login.activity.OnboardingActivity


class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        binding.navView.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.navigation_dashboard -> {
//                    Toast.makeText(this, "Shipment", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//            true
//        }

        headerToolbar()
    }

    private fun headerToolbar() {
        binding.apply {
            dashboardMain.headerTitle.text = String.format("Shipments")
            dashboardMain.ivNotification.setOnClickListener {
                Toast.makeText(this@DashboardActivity, "Notification", Toast.LENGTH_SHORT).show()
            }
            dashboardMain.ivSearch.setOnClickListener {
                Toast.makeText(this@DashboardActivity, "Search", Toast.LENGTH_SHORT).show()
            }
            dashboardMain.menuItem.setOnClickListener {
                val intent = Intent(this@DashboardActivity,OnboardingActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}