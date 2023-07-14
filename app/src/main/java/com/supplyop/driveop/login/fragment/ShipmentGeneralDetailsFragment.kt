package com.supplyop.driveop.login.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.supplyop.driveop.databinding.FragmentShipmentGeneralDetailsBinding


class ShipmentGeneralDetailsFragment(
    private var shipmentId: String?,
    private var date: String?,
    private var address: String?,
    private var truckProgress: Int?
) : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentShipmentGeneralDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentShipmentGeneralDetailsBinding.inflate(inflater, container, false)

        binding.apply {

            tvShipment.text = shipmentId
            tvDateTime.text = date
            tvAddress.text = address
            progressTruck.progress = truckProgress ?: 0
            progressTruck.isEnabled = false

            when (progressTruck.progress) {
                100 -> {
                    progressTruck.progressTintList = ColorStateList.valueOf(Color.GREEN)
                }

                in 10..30 -> {
                    progressTruck.progressTintList = ColorStateList.valueOf(Color.RED)
                }

                else -> {
                    progressTruck.progressTintList = ColorStateList.valueOf(Color.YELLOW)
                }
            }

            ivDirection.setOnClickListener {
                Toast.makeText(context, "Direction", Toast.LENGTH_SHORT).show()
            }
            ivChat.setOnClickListener {
                Toast.makeText(context, "Chat", Toast.LENGTH_SHORT).show()
            }
            ivCall.setOnClickListener {
                Toast.makeText(context, "Call", Toast.LENGTH_SHORT).show()
            }
            ivDirection2.setOnClickListener {
                Toast.makeText(context, "Direction", Toast.LENGTH_SHORT).show()
            }
            ivCall2.setOnClickListener {
                Toast.makeText(context, "Call", Toast.LENGTH_SHORT).show()
            }
            btnLetsGo.setOnClickListener {
                Toast.makeText(context, "Let's Go", Toast.LENGTH_SHORT).show()
            }


        }



        return binding.root
    }


}