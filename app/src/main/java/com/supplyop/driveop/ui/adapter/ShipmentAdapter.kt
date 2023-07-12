package com.supplyop.driveop.ui.adapter

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ItemShipmentBinding
import com.supplyop.driveop.ui.activity.ShipmentDetailsActivity
import com.supplyop.driveop.ui.modelclass.ShipmentResponse


class ShipmentAdapter(private val shipmentData: List<ShipmentResponse>) : RecyclerView.Adapter<ShipmentAdapter.ViewHolder>() {

    private lateinit var binding: ItemShipmentBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipmentAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemShipmentBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShipmentAdapter.ViewHolder, position: Int) {


        val shipment = shipmentData[position]
        holder.itemBinding.apply {

            tvDetails.setOnClickListener {

                val intent = Intent(it.context, ShipmentDetailsActivity::class.java)
                intent.putExtra("shipmentId", shipment.shipmentId)
                intent.putExtra("date", shipment.date)
                intent.putExtra("address", shipment.address)
                intent.putExtra("truckProgress", shipment.truckProgress)
                it.context.startActivity(intent)

            }

            tvShipment.setOnClickListener {
                if (shipment.isSelector) {
                    tvShipment.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0)
                    groupIds.visibility = View.GONE
                    shipment.isSelector = false
                } else {
                    tvShipment.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0)
                    groupIds.visibility = View.VISIBLE
                    shipment.isSelector = true
                }
            }

            tvShipment.text = shipment.shipmentId
            tvDateTime.text = shipment.date
            tvAddress.text = shipment.address

            progressTruck.progress = shipment.truckProgress
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




        }


    }

    override fun getItemCount(): Int {
        return shipmentData.size
    }

    inner class ViewHolder(var itemBinding: ItemShipmentBinding) : RecyclerView.ViewHolder(itemBinding.root)
}


