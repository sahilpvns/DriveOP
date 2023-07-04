package com.supplyop.driveop.login.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentFuelEfficiencyBinding
import com.supplyop.driveop.login.activity.LoginActivity


class FuelEfficiencyFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentFuelEfficiencyBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFuelEfficiencyBinding.inflate(inflater, container, false)


        binding.btnNext.setOnClickListener {
            val fragment: Fragment = EarnMoreFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }

        binding.btnLoginNow.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }


        return binding.root
    }


}