package com.supplyop.driveop.login.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ActivityGoogleMapDirectionBinding
import com.supplyop.driveop.login.fragment.MapsFragment


class GoogleMapDirectionActivity : AppCompatActivity(){

    private var binding: ActivityGoogleMapDirectionBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGoogleMapDirectionBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        supportActionBar?.hide()
        toolbarMap()

        if (savedInstanceState == null) { // initial transaction should be wrapped like this
            val fragment: Fragment = MapsFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frameMapView, fragment).commitAllowingStateLoss()
        }

    }

    private fun toolbarMap() {
        binding?.apply {
            toolbarMap.apply {
                headerTitle.text = String.format("Direction")
                menuItem.setBackgroundResource(R.drawable.arrow_back)
                menuItem.setOnClickListener { finish() }
            }
        }
    }

}