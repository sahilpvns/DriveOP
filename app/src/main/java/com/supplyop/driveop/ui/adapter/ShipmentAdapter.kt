package com.supplyop.driveop.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.supplyop.driveop.R
import com.supplyop.driveop.databinding.ItemShipmentBinding
import com.supplyop.driveop.ui.shipment.ShipmentDetailsFragment


class ShipmentAdapter() : RecyclerView.Adapter<ShipmentAdapter.ViewHolder>() {

    private lateinit var binding: ItemShipmentBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipmentAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemShipmentBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShipmentAdapter.ViewHolder, position: Int) {
        holder.itemBinding.tvShipment.setOnClickListener {

//            if (holder.itemBinding.tvShipment.visibility == View.GONE) {
//                holder.itemBinding.tvShipment.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0)
//            } else {
//                holder.itemBinding.tvShipment.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0)
//            }

        }


        holder.itemBinding.tvDetails.setOnClickListener {

//            val myFragment: Fragment = ShipmentDetailsFragment()
//            (it.context as FragmentActivity).supportFragmentManager.beginTransaction()
//                .replace(com.supplyop.driveop.R.id.nav_host_fragment_activity_main, myFragment)
//                .addToBackStack(null).commit()

            //    val fragment: Fragment = ShipmentDetailsFragment()
            //    (it.context as FragmentActivity).supportFragmentManager.beginTransaction().replace(com.supplyop.driveop.R.id.containerDashboard, fragment).commitAllowingStateLoss()

            val fragment: Fragment = ShipmentDetailsFragment()
            val fragmentManager: FragmentManager =
                (it.context as FragmentActivity).supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit()


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


