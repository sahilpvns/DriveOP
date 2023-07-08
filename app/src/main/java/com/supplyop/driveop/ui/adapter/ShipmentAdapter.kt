package com.supplyop.driveop.ui.adapter

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ItemShipmentBinding
import com.supplyop.driveop.login.api.method.LoginResponse
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

            tvShipment.text = shipment.shipmentId
            tvDateTime.text = shipment.date
            tvAddress.text = shipment.address

            tvDetails.setOnClickListener {
                val intent = Intent(it.context, ShipmentDetailsActivity::class.java)
                it.context.startActivity(intent)

            }


            progressTruck.progress = shipment.truckProgress
            progressTruck.isEnabled = false

            if (progressTruck.progress == 100) {
                progressTruck.progressTintList = ColorStateList.valueOf(Color.GREEN)
            } else if (progressTruck.progress < 99) {
                progressTruck.progressTintList = ColorStateList.valueOf(Color.YELLOW)
            }


        }


    }

    override fun getItemCount(): Int {
        return shipmentData.size
    }

    inner class ViewHolder(var itemBinding: ItemShipmentBinding) : RecyclerView.ViewHolder(itemBinding.root)
}


