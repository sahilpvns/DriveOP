package com.supplyop.driveop.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.supplyop.driveop.databinding.ItemShipmentBinding

class ShipmentAdapter() : RecyclerView.Adapter<ShipmentAdapter.ViewHolder>() {

    private lateinit var binding: ItemShipmentBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipmentAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemShipmentBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShipmentAdapter.ViewHolder, position: Int) {
        holder.itemBinding.tvDetails.setOnClickListener {
            Toast.makeText(it.context, "click Details", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = 15

    inner class ViewHolder(var itemBinding: ItemShipmentBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
//        fun bind(item: String) {
//            binding.apply {
//                tvShipment.text = String.format("Shipment- #2732682")
//                tvAddress.text = String.format("31-05-2023 - 31-05-2023")
//            }
//        }
    }
}


