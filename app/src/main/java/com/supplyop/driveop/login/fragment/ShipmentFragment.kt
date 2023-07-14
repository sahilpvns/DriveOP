package com.supplyop.driveop.login.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentShipmentBinding
import com.supplyop.driveop.login.viewmodel.ShipmentViewModel

class ShipmentFragment : Fragment() {

    private var _binding: FragmentShipmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val shipmentViewModel = ViewModelProvider(this)[ShipmentViewModel::class.java]
        _binding = FragmentShipmentBinding.inflate(inflater, container, false)

        binding.apply {
            tvCurrent.setOnClickListener {

                tvCurrent.backgroundTintList= it.context.getColorStateList(R.color.dark_blue)
                tvCurrent.setTextColor(ContextCompat.getColor(it.context, R.color.white))

                tvCompleted.backgroundTintList= it.context.getColorStateList(R.color.white)
                tvCompleted.setTextColor(ContextCompat.getColor(it.context, R.color.dark_blue))

                val fragment: Fragment = ShipmentCurrentFragment()
                val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
            }

            tvCompleted.setOnClickListener {

                tvCurrent.backgroundTintList= it.context.getColorStateList(R.color.white)
                tvCurrent.setTextColor(ContextCompat.getColor(it.context, R.color.dark_blue))

                tvCompleted.backgroundTintList= it.context.getColorStateList(R.color.dark_blue)
                tvCompleted.setTextColor(ContextCompat.getColor(it.context, R.color.white))


                val fragment: Fragment = ShipmentCompletedFragment()
                val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()


            }

            if (savedInstanceState == null) { // initial transaction should be wrapped like this
                val fragment: Fragment = ShipmentCurrentFragment()
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.commitAllowingStateLoss()
            }

        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
