package com.supplyop.driveop.ui.modelclass

import com.google.gson.annotations.SerializedName
import java.nio.channels.Selector

class ShipmentResponse(

    @SerializedName("shipmentId") val shipmentId: String = "",
    @SerializedName("date") val date: String = " ",
    @SerializedName("address") val address: String = "",
    @SerializedName("truckProgress") val truckProgress: Int = 0,
    var isSelector: Boolean = false

)