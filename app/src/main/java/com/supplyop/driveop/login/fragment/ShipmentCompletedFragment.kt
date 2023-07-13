package com.supplyop.driveop.login.fragment

import android.app.ProgressDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.supplyop.driveop.databinding.FragmentShipmentCompletedBinding
import com.supplyop.driveop.ui.adapter.ShipmentCurrentAdapter
import com.supplyop.driveop.ui.modelclass.ShipmentResponse
import com.supplyop.driveop.ui.network.RetrofitInstance
import com.supplyop.driveop.utils.withColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ShipmentCompletedFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentShipmentCompletedBinding? = null

    private val shipmentList = ArrayList<ShipmentResponse>()
    lateinit var shipmentCompletedAdapter: ShipmentCurrentAdapter
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentShipmentCompletedBinding.inflate(inflater, container, false)

        shipmentCompletedAdapter = ShipmentCurrentAdapter(shipmentList)
        binding.rvItemShipmentCompleted.layoutManager = LinearLayoutManager(context)
        binding.rvItemShipmentCompleted.adapter = shipmentCompletedAdapter
        progressDialog = ProgressDialog.show(context, "Loading", "Fetching Data Please wait...", false)

        getShipmentData()

        return binding.root
    }

    private fun getShipmentData() {

        val call: Call<List<ShipmentResponse>> = RetrofitInstance.getClient.getShipmentCompletedList()
        call.enqueue(object : Callback<List<ShipmentResponse>?> {
            override fun onFailure(call: Call<List<ShipmentResponse>?>, t: Throwable) {
                Snackbar.make(binding.root, "Something went wrong $t", Snackbar.LENGTH_LONG).withColor(Color.RED).show()
                progressDialog.dismiss()
            }

            override fun onResponse(call: Call<List<ShipmentResponse>?>, response: Response<List<ShipmentResponse>?>) {
                if (response.isSuccessful && response.body() != null) {
                    val listShipment = response.body()!!
                    shipmentList.addAll(listShipment)
                    shipmentCompletedAdapter.notifyDataSetChanged()
                } else {
                    Snackbar.make(binding.root, "Something went wrong", Snackbar.LENGTH_LONG).withColor(Color.RED).show()
                }
                progressDialog.dismiss()
            }
        })

    }

}