package com.supplyop.driveop.login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentCommentsBinding
import com.supplyop.driveop.databinding.FragmentShipmentGeneralDetailsBinding


class CommentsFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentCommentsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentCommentsBinding.inflate(inflater, container, false)


        return binding.root
    }


}