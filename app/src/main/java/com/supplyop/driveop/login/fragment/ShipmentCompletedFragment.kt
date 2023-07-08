package com.supplyop.driveop.login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.supplyop.driveop.databinding.FragmentShipmentCompletedBinding
import com.supplyop.driveop.ui.adapter.ShipmentAdapter


class ShipmentCompletedFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentShipmentCompletedBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentShipmentCompletedBinding.inflate(inflater, container, false)

//        binding.apply {
//            rvItemShipment.layoutManager = LinearLayoutManager(context)
//            rvItemShipment.adapter = ShipmentAdapter(photosList)
//        }

        return binding.root
    }

}