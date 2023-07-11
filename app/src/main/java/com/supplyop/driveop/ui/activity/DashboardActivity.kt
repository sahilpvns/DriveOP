package com.supplyop.driveop.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ActivityDashboardBinding
import com.supplyop.driveop.ui.leaderboard.LeaderboardFragment
import com.supplyop.driveop.ui.shipment.ShipmentFragment
import com.supplyop.driveop.ui.vehicle_inspection.VehicleInspectionFragment


class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            val fragment: Fragment = ShipmentFragment()
            supportFragmentManager.beginTransaction().replace(R.id.navigationDashboard, fragment).commitAllowingStateLoss()
        }


        binding.apply {
            val toggle = ActionBarDrawerToggle(this@DashboardActivity, drawerLayout, R.string.drawer_open, R.string.drawer_close)


            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            navStart.setNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.nav_item1 -> {
                        Toast.makeText(this@DashboardActivity, "click", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.nav_item2 -> {
                        Toast.makeText(this@DashboardActivity, "click2", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }
            }


            navView.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.leaderboard -> {
                        openLeaderboardFragment()
                        true
                    }

                    R.id.shipment -> {
                        openShipmentFragment()
                        true
                    }

                    R.id.vehicleInspection -> {
                        openVehicleInspectionFragment()
                        true
                    }

                    else -> false
                }
            }

        }

        headerToolbar()
    }

    private fun openVehicleInspectionFragment() {
        val fragment: Fragment = VehicleInspectionFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.navigationDashboard, fragment).commit()
    }

    private fun openShipmentFragment() {
        val fragment: Fragment = ShipmentFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.navigationDashboard, fragment).commit()
    }

    private fun openLeaderboardFragment() {
        val fragment: Fragment = LeaderboardFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.navigationDashboard, fragment).commit()
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
//                val intent = Intent(this@DashboardActivity, OnboardingActivity::class.java)
//                startActivity(intent)
//                finish()
            }
        }
    }

}