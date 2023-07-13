package com.supplyop.driveop.login.network

import com.google.gson.annotations.SerializedName

class ShipmentResponse(

    @SerializedName("shipmentId") val shipmentId: String = "",
    @SerializedName("date") val date: String = " ",
    @SerializedName("address") val address: String = "",
    @SerializedName("truckProgress") val truckProgress: Int = 0,
    var isSelector: Boolean = false

)