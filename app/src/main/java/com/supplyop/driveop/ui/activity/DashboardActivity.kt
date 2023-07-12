package com.supplyop.driveop.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ActivityDashboardBinding
import com.supplyop.driveop.ui.leaderboard.LeaderboardFragment
import com.supplyop.driveop.ui.shipment.ShipmentFragment
import com.supplyop.driveop.ui.vehicle_inspection.VehicleInspectionFragment


class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    lateinit var toggle: ActionBarDrawerToggle

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

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navStart.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.vehicleInspection -> {
                        Toast.makeText(this@DashboardActivity, "vehicleInspection", Toast.LENGTH_SHORT).show()
                    }

                    R.id.myRoutes -> {
                        Toast.makeText(this@DashboardActivity, "tvMyRoutes", Toast.LENGTH_SHORT).show()
                    }

                    R.id.aboutCompany -> {
                        Toast.makeText(this@DashboardActivity, "aboutCompany", Toast.LENGTH_SHORT).show()
                    }

                    R.id.contactUs -> {
                        Toast.makeText(this@DashboardActivity, "contactUs", Toast.LENGTH_SHORT).show()
                    }

                    R.id.termsConditions -> {
                        Toast.makeText(this@DashboardActivity, "termsConditions", Toast.LENGTH_SHORT).show()
                    }

                    R.id.privacyPolicy -> {
                        Toast.makeText(this@DashboardActivity, "privacyPolicy", Toast.LENGTH_SHORT).show()
                    }

                }
                true
            }


            navView.setOnNavigationItemSelectedListener {menuItem ->
                when (menuItem.itemId) {
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
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
                if (!drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.openDrawer(GravityCompat.START)
                else drawerLayout.closeDrawer(GravityCompat.END)
            }
        }
    }

}