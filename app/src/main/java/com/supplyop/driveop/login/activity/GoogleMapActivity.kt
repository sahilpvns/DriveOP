package com.supplyop.driveop.login.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ActivityGoogleMapBinding
import com.supplyop.driveop.login.adapter.MapRouteAdapter


class GoogleMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView

    private var binding: ActivityGoogleMapBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGoogleMapBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        supportActionBar?.hide()
        toolbarMap()

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        binding?.rvMapRoute?.adapter = MapRouteAdapter()
        binding?.rvMapRoute?.layoutManager = LinearLayoutManager(this)

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

    override fun onMapReady(map: GoogleMap) {

        val location = LatLng(28.46995023050021, 77.01925805425242)
        map.addMarker(MarkerOptions().position(location).title("Gurugram"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12.0f))
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}