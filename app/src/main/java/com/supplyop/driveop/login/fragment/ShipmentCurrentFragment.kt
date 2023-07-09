package com.supplyop.driveop.login.fragment

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.supplyop.driveop.databinding.FragmentShipmentCurrentBinding
import com.supplyop.driveop.ui.adapter.ShipmentAdapter
import com.supplyop.driveop.ui.modelclass.ShipmentResponse
import com.supplyop.driveop.ui.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShipmentCurrentFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentShipmentCurrentBinding? = null

    private val shipmentList = ArrayList<ShipmentResponse>()
    lateinit var shipmentAdapter: ShipmentAdapter
    lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentShipmentCurrentBinding.inflate(inflater, container, false)


        shipmentAdapter = ShipmentAdapter(shipmentList)
        binding.rvItemShipment.layoutManager = LinearLayoutManager(context)
        binding.rvItemShipment.adapter = shipmentAdapter
        progressDialog = ProgressDialog.show(context, "Loading", "Fetching Data Please wait...", false)

        getShipmentData()


        return binding.root
    }

    private fun getShipmentData() {

        val call: Call<List<ShipmentResponse>> = RetrofitInstance.getClient.getShipmentList()
        call.enqueue(object : Callback<List<ShipmentResponse>?> {
            override fun onFailure(call: Call<List<ShipmentResponse>?>, t: Throwable) {
                Toast.makeText(context, "Something went wrong $t", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }

            override fun onResponse(call: Call<List<ShipmentResponse>?>, response: Response<List<ShipmentResponse>?>) {
                if (response.isSuccessful && response.body() != null) {
                    val listShipment = response.body()!!
                    shipmentList.addAll(listShipment)
                    shipmentAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(context, "Something went wrong${response.body()}", Toast.LENGTH_SHORT).show()
                }
                progressDialog.dismiss()
            }
        })


    }


}