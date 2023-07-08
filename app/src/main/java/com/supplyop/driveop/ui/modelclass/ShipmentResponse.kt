package com.supplyop.driveop.ui.modelclass

import com.google.gson.annotations.SerializedName

class ShipmentResponse(

    @SerializedName("shipmentId") val shipmentId: String = "",
    @SerializedName("date") val date: String = " ",
    @SerializedName("address") val address: String = "",
    @SerializedName("truckProgress") val truckProgress: Int = 0

)