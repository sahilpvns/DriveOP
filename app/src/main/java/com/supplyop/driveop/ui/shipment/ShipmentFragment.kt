package com.supplyop.driveop.ui.shipment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.supplyop.driveop.databinding.FragmentShipmentBinding
import com.supplyop.driveop.login.activity.LoginActivity
import com.supplyop.driveop.login.activity.OnboardingActivity

class ShipmentFragment : Fragment() {

    private var _binding: FragmentShipmentBinding? = null
    private val binding get() = _binding!!

    var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val shipmentViewModel = ViewModelProvider(this)[ShipmentViewModel::class.java]

        _binding = FragmentShipmentBinding.inflate(inflater, container, false)

        sharedPreferences = activity?.getSharedPreferences(SHARED_PREF_NAME, AppCompatActivity.MODE_PRIVATE)

        binding.apply {
            tvCurrent.setOnClickListener {
                val intent = Intent(context, OnboardingActivity::class.java)
                startActivity(intent)
            }
            tvCompleted.setOnClickListener {
                val editor = sharedPreferences?.edit()
                editor?.clear()
                editor?.apply()
                activity?.finish()

                val intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)
                activity?.finish()

            }
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        private const val SHARED_PREF_NAME = "MyPref"
        private const val KEY_NAME = "name"
        private const val KEY_NUMBER = "number"
    }
}
