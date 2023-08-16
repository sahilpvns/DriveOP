package com.supplyop.driveop.login.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.supplyop.driveop.databinding.MapItemRouteBinding

class MapRouteAdapter() : RecyclerView.Adapter<MapRouteAdapter.ViewHolder>() {

    private lateinit var binding: MapItemRouteBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = MapItemRouteBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}

    override fun getItemCount(): Int {
        return 3
    }

    inner class ViewHolder(private var itemBinding: MapItemRouteBinding) : RecyclerView.ViewHolder(itemBinding.root)
}


