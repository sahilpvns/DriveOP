package com.supplyop.driveop.ui.shipment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentFuelEfficiencyBinding
import com.supplyop.driveop.databinding.FragmentShipmentBinding
import com.supplyop.driveop.login.activity.WelcomeNoteActivity
import com.supplyop.driveop.login.fragment.EarnMoreFragment

class ShipmentFragment : Fragment() {

    private var _binding: FragmentShipmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val shipmentViewModel = ViewModelProvider(this)[ShipmentViewModel::class.java]

        _binding = FragmentShipmentBinding.inflate(inflater, container, false)

        binding.apply {
            tvCurrent.setOnClickListener {
                val intent = Intent(context, WelcomeNoteActivity::class.java)
                startActivity(intent)
            }
            tvCompleted.setOnClickListener {
                Toast.makeText(context, "Completed", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
