package com.supplyop.driveop.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ActivityShipmentDetailsBinding
import com.supplyop.driveop.login.activity.OnboardingActivity
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
            supportFragmentManager.beginTransaction().replace(R.id.shipment_container, fragment).commitAllowingStateLoss()
        }

        binding?.apply {

            tvGeneral.setOnClickListener {
                tvGeneral.backgroundTintList= getColorStateList(R.color.dark_blue)
                tvGeneral.setTextColor(ContextCompat.getColor(this@ShipmentDetailsActivity, R.color.white))

                tvComment.backgroundTintList= getColorStateList(R.color.white)
                tvComment.setTextColor(ContextCompat.getColor(this@ShipmentDetailsActivity, R.color.dark_blue))

                tvDigitalCopies.backgroundTintList= getColorStateList(R.color.white)
                tvDigitalCopies.setTextColor(ContextCompat.getColor(this@ShipmentDetailsActivity, R.color.dark_blue))

                // open ShipmentDetailsFragment
                val fragment: Fragment = ShipmentGeneralDetailsFragment()
                val fragmentManager: FragmentManager = supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.shipment_container, fragment).commit()
            }


            tvComment.setOnClickListener {
                tvGeneral.backgroundTintList= getColorStateList(R.color.white)
                tvGeneral.setTextColor(ContextCompat.getColor(this@ShipmentDetailsActivity, R.color.dark_blue))

                tvComment.backgroundTintList= getColorStateList(R.color.dark_blue)
                tvComment.setTextColor(ContextCompat.getColor(this@ShipmentDetailsActivity, R.color.white))

                tvDigitalCopies.backgroundTintList= getColorStateList(R.color.white)
                tvDigitalCopies.setTextColor(ContextCompat.getColor(this@ShipmentDetailsActivity, R.color.dark_blue))

                // open CommentFragment
                val fragment: Fragment = CommentsFragment()
                val fragmentManager: FragmentManager = supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.shipment_container, fragment).commit()
            }

            tvDigitalCopies.setOnClickListener {
                tvGeneral.backgroundTintList= getColorStateList(R.color.white)
                tvGeneral.setTextColor(ContextCompat.getColor(this@ShipmentDetailsActivity, R.color.dark_blue))

                tvComment.backgroundTintList= getColorStateList(R.color.white)
                tvComment.setTextColor(ContextCompat.getColor(this@ShipmentDetailsActivity, R.color.dark_blue))

                tvDigitalCopies.backgroundTintList= getColorStateList(R.color.dark_blue)
                tvDigitalCopies.setTextColor(ContextCompat.getColor(this@ShipmentDetailsActivity, R.color.white))

                // Open DigitalCopiesFragment
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