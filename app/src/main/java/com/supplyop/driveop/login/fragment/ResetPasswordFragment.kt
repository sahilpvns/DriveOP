package com.supplyop.driveop.login.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentFuelEfficiencyBinding
import com.supplyop.driveop.databinding.FragmentResetPasswordBinding


class ResetPasswordFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentResetPasswordBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = FragmentResetPasswordBinding.inflate(inflater, container, false)

       binding.btnSubmit.setOnClickListener {
            val fragment: Fragment = EnterOtpFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }


        return binding.root
    }


}