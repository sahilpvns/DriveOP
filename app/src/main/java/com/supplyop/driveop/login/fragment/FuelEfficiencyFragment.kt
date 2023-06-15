package com.supplyop.driveop.login.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import com.supplyop.driveop.R
import com.supplyop.driveop.login.activity.LoginActivity


class FuelEfficiencyFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fuel_efficiency, container, false)


        val btn = view.findViewById<TextView>(R.id.btnNext)
        btn.setOnClickListener {
            val fragment: Fragment = EarnMoreFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }

        val btnLoginNow = view.findViewById<TextView>(com.supplyop.driveop.R.id.btnLoginNow)
        btnLoginNow.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }


        return view
    }


}