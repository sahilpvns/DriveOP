package com.supplyop.driveop.login.network

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("shipmentCurrent")
    fun getShipmentCurrentList(): Call<List<ShipmentResponse>>

    @GET("shipmentCompleted")
    fun getShipmentCompletedList(): Call<List<ShipmentResponse>>
}