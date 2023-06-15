package com.supplyop.driveop.login.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.supplyop.driveop.databinding.FragmentShortestDistanceBinding
import com.supplyop.driveop.login.activity.LoginActivity


class ShortestDistanceFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentShortestDistanceBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShortestDistanceBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
            val fragment: Fragment = FuelEfficiencyFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().replace(com.supplyop.driveop.R.id.container, fragment).commit()
        }

        binding.btnLoginNow.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return binding.root

    }

}