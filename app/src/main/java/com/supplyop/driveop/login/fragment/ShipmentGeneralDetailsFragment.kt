package com.supplyop.driveop.login.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.supplyop.driveop.databinding.FragmentShipmentGeneralDetailsBinding


class ShipmentGeneralDetailsFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentShipmentGeneralDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentShipmentGeneralDetailsBinding.inflate(inflater, container, false)

        binding.apply {
            progressTruck.progress = 90
            progressTruck.isEnabled = false

            if (progressTruck.progress == 100) {
                progressTruck.progressTintList = ColorStateList.valueOf(Color.GREEN)
            } else if (progressTruck.progress <= 50) {
                progressTruck.progressTintList = ColorStateList.valueOf(Color.YELLOW)
            } else {
                progressTruck.progressTintList = ColorStateList.valueOf(Color.YELLOW)
            }
        }



        return binding.root
    }


}