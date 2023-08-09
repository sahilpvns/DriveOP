package com.supplyop.driveop.login.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ActivityGoogleMapDirectionBinding
import com.supplyop.driveop.databinding.ActivityShipmentDetailsBinding
import com.supplyop.driveop.login.fragment.MapsFragment
import com.supplyop.driveop.login.fragment.ShortestDistanceFragment


class GoogleMapDirectionActivity : AppCompatActivity(){

    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_map_direction)

        supportActionBar?.hide()

        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            val fragment: Fragment = MapsFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frameMapView, fragment).commitAllowingStateLoss()
        }

    }

}