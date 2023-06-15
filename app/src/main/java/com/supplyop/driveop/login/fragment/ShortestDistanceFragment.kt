package com.supplyop.driveop.login.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import com.supplyop.driveop.login.activity.LoginActivity


class ShortestDistanceFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(com.supplyop.driveop.R.layout.fragment_shortest_distance, container, false)

        val btn = view.findViewById<TextView>(com.supplyop.driveop.R.id.btnNext)
        btn.setOnClickListener {
            val fragment: Fragment = FuelEfficiencyFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().replace(com.supplyop.driveop.R.id.container, fragment).commit()
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