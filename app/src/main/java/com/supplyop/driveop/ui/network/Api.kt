package com.supplyop.driveop.ui.network

import com.supplyop.driveop.ui.modelclass.ShipmentResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("shipment")
    fun getShipmentList(): Call<List<ShipmentResponse>>
}