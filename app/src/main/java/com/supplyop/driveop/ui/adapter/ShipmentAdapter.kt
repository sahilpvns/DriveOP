package com.supplyop.driveop.ui.adapter

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.supplyop.driveop.databinding.ItemShipmentBinding
import com.supplyop.driveop.login.api.method.LoginResponse
import com.supplyop.driveop.ui.activity.ShipmentDetailsActivity


class ShipmentAdapter( ) : RecyclerView.Adapter<ShipmentAdapter.ViewHolder>() {
    private lateinit var languageList: List<LoginResponse>
    private lateinit var binding: ItemShipmentBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipmentAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemShipmentBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShipmentAdapter.ViewHolder, position: Int) {
        holder.itemBinding.apply {

            tvShipment.setOnClickListener {}

            tvDetails.setOnClickListener {
                val intent = Intent(it.context, ShipmentDetailsActivity::class.java)
                it.context.startActivity(intent)

            }



            progressTruck.progress = 90
            progressTruck.isEnabled = false

            if (progressTruck.progress == 100) {
                progressTruck.progressTintList = ColorStateList.valueOf(Color.GREEN)
            } else if (progressTruck.progress <= 50) {
                progressTruck.progressTintList = ColorStateList.valueOf(Color.YELLOW)
            } else{
                progressTruck.progressTintList = ColorStateList.valueOf(Color.YELLOW)
            }


        }


//        android:drawableEnd="@{item.selected ? (ContextCompat.getDrawable(context,R.drawable.ic_arrow_up_blue)) :
//        (ContextCompat.getDrawable(context,R.drawable.ic_arrow_down_2_blue))}"


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


