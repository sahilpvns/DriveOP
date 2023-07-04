package com.supplyop.driveop.login.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentCommentsBinding
import com.supplyop.driveop.databinding.FragmentDigitalCopiesBinding
import com.supplyop.driveop.databinding.FragmentShipmentGeneralDetailsBinding


class DigitalCopiesFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentDigitalCopiesBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentDigitalCopiesBinding.inflate(inflater, container, false)


        return binding.root

    }


}