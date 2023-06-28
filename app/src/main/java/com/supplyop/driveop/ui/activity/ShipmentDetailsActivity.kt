package com.supplyop.driveop.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ActivityShipmentDetailsBinding
import com.supplyop.driveop.login.fragment.CommentsFragment
import com.supplyop.driveop.login.fragment.DigitalCopiesFragment
import com.supplyop.driveop.login.fragment.ShipmentGeneralDetailsFragment


class ShipmentDetailsActivity : AppCompatActivity() {

    private var binding: ActivityShipmentDetailsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShipmentDetailsBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        supportActionBar?.hide()
        headerToolbar()

        if (savedInstanceState == null) { // initial transaction should be wrapped like this
            val fragment: Fragment = ShipmentGeneralDetailsFragment()
            supportFragmentManager.beginTransaction().replace(R.id.shipment_container, fragment)
                .commitAllowingStateLoss()
        }

        binding?.apply {

            tvGeneral.setOnClickListener {
                val fragment: Fragment = ShipmentGeneralDetailsFragment()
                val fragmentManager: FragmentManager = supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.shipment_container, fragment).commit()
            }

            tvComment.setOnClickListener {
                val fragment: Fragment = CommentsFragment()
                val fragmentManager: FragmentManager = supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.shipment_container, fragment).commit()
            }

            tvDigitalCopies.setOnClickListener {
                val fragment: Fragment = DigitalCopiesFragment()
                val fragmentManager: FragmentManager = supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.shipment_container, fragment).commit()

            }


        }


    }

    private fun headerToolbar() {
        binding?.apply {
            shipmentDetails.headerTitle.text = String.format("Shipment- #2732682")
        }


    }

}
