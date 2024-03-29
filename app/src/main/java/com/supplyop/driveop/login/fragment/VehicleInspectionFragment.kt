package com.supplyop.driveop.login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.supplyop.driveop.databinding.FragmentVehicleInspectionBinding
import com.supplyop.driveop.login.viewmodel.VehicleInspectionViewModel

class VehicleInspectionFragment : Fragment() {

    private var _binding: FragmentVehicleInspectionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        val vehicleInspectionViewModel =
            ViewModelProvider(this)[VehicleInspectionViewModel::class.java]

        _binding = FragmentVehicleInspectionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        vehicleInspectionViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}