package com.supplyop.driveop.login.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.supplyop.driveop.databinding.FragmentShipmentCurrentBinding
import com.supplyop.driveop.ui.adapter.ShipmentAdapter

class ShipmentCurrentFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentShipmentCurrentBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentShipmentCurrentBinding.inflate(inflater, container, false)

        binding.apply {
            rvItemShipment.layoutManager = LinearLayoutManager(context)
            rvItemShipment.adapter = ShipmentAdapter()
        }


        return binding.root
    }


}