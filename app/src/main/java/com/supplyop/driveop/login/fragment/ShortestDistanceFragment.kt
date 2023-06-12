package com.supplyop.driveop.login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


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
            fragmentManager.beginTransaction().replace(com.supplyop.driveop.R.id.shipfram, fragment).commit()
        }

        return view

    }

}