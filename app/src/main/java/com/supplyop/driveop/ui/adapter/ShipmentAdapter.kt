package com.supplyop.driveop.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ItemShipmentBinding
import com.supplyop.driveop.ui.activity.ShipmentDetailsActivity


class ShipmentAdapter() : RecyclerView.Adapter<ShipmentAdapter.ViewHolder>() {

    private lateinit var binding: ItemShipmentBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipmentAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemShipmentBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShipmentAdapter.ViewHolder, position: Int) {
        holder.itemBinding.tvShipment.setOnClickListener {

//            var flag = true
//            if (flag) {
//                holder.itemBinding.tvShipment.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0)
//                flag = true
//            } else {
//                holder.itemBinding.tvShipment.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0)
//               flag=  false
//            }

        }

        holder.itemBinding.tvDetails.setOnClickListener {
            val intent = Intent(it.context, ShipmentDetailsActivity::class.java)
            it.context.startActivity(intent)

        }
    }

    override fun getItemCount() = 15


    inner class ViewHolder(var itemBinding: ItemShipmentBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

//        fun bind(item: String) {
//            binding.apply {
//                tvShipment.text = String.format("Shipment- #2732682 adfqf")
//                tvAddress.text = String.format("31-05-2023 - 31-05-2023 asdfqwf")
//            }
//        }
    }
}


