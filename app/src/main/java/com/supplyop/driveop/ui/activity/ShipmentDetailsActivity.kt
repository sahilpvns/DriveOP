package com.supplyop.driveop.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.supplyop.driveop.databinding.ActivityShipmentDetailsBinding


class ShipmentDetailsActivity : AppCompatActivity() {

    private var binding: ActivityShipmentDetailsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShipmentDetailsBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        supportActionBar?.hide()
        headerToolbar()


    }

    private fun headerToolbar() {
        binding?.apply {
            shipmentDetails.headerTitle.text = String.format("Shipment- #2732682")
        }


    }

}
