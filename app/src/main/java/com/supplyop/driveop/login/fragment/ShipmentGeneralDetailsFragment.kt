package com.supplyop.driveop.login.fragment

import android.app.Dialog
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.FragmentShipmentGeneralDetailsBinding
import com.supplyop.driveop.login.activity.ChatActivity
import com.supplyop.driveop.login.activity.GoogleMapActivity


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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
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
                val intent = Intent(context, GoogleMapActivity::class.java)
                startActivity(intent)
            }
            ivChat.setOnClickListener {
                val intent = Intent(context, ChatActivity::class.java)
                startActivity(intent)
            }
            ivCall.setOnClickListener {
                alertdialogCall()
            }
            ivDirection2.setOnClickListener {
                val intent = Intent(context, GoogleMapActivity::class.java)
                startActivity(intent)
            }
            ivCall2.setOnClickListener {
                alertdialogCall()
            }
            btnLetsGo.setOnClickListener {
                Toast.makeText(context, "Let's Go", Toast.LENGTH_SHORT).show()
            }


        }



        return binding.root
    }

    private fun alertdialogCall() {

        val customDialog = Dialog(requireActivity())
        customDialog.setContentView(R.layout.alertdialog_call)
        customDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val yesBtn = customDialog.findViewById<Button>(R.id.btnYes)
        val noBtn = customDialog.findViewById<Button>(R.id.btnNo)
        val tvSureCall = customDialog.findViewById<TextView>(R.id.tvSureCall)

        val number = 9958020399

        tvSureCall.text = String.format("Are you sure you want to Call On +91-$number")
        yesBtn.setOnClickListener {

            val dial = Intent(Intent.ACTION_DIAL)
            try {
                dial.data = Uri.parse("tel:$number")
                startActivity(dial)
            } catch (e: Exception) { }

            startActivity(dial)
            customDialog.dismiss()
        }
        noBtn.setOnClickListener {
            customDialog.dismiss()
        }

        customDialog.show()

    }

}