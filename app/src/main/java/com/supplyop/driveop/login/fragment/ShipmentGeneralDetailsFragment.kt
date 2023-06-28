package com.supplyop.driveop.login.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentEarnMoreBinding
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




        return binding.root
    }


}