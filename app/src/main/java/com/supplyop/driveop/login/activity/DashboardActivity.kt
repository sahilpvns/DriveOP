package com.supplyop.driveop.login.activity

import android.content.Intent
import android.content.SharedPreferences
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
import com.supplyop.driveop.login.fragment.LeaderboardFragment
import com.supplyop.driveop.login.fragment.ShipmentFragment
import com.supplyop.driveop.login.fragment.VehicleInspectionFragment


class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    lateinit var toggle: ActionBarDrawerToggle

    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)


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

                    R.id.logOut -> {
                        val editor = sharedPreferences?.edit()
                        editor?.clear()
                        editor?.apply()
                        finish()

                        val intent = Intent(this@DashboardActivity, LoginActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this@DashboardActivity, "logout", Toast.LENGTH_SHORT).show()
                        finish()

                    }

                }
                true
            }

            navView.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.leaderboard -> {
                        openLeaderboardFragment()
                    }

                    R.id.shipment -> {
                        openShipmentFragment()
                    }

                    R.id.vehicleInspection -> {
                        openVehicleInspectionFragment()
                    }
                }
                true
            }

        }

        headerToolbar()
    }

    companion object {
        private const val SHARED_PREF_NAME = "MyPref"
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
            dashboardMain.apply {
                headerTitle.text = String.format("Shipments")
                ivNotification.setOnClickListener {
                    Toast.makeText(this@DashboardActivity, "Notification", Toast.LENGTH_SHORT).show()
                }
                ivSearch.setOnClickListener {
                    Toast.makeText(this@DashboardActivity, "Search", Toast.LENGTH_SHORT).show()
                }
                menuItem.setOnClickListener {
                    if (!drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.openDrawer(GravityCompat.START)
                    else {
                        drawerLayout.closeDrawer(GravityCompat.END)
                    }
                }
            }
        }
    }

}