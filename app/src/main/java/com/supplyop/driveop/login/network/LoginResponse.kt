package com.supplyop.driveop.login.network

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code") var code: Int,
    @SerializedName("message") var message: String,
    @SerializedName("data") var data: Data,
)

data class Data(
    @SerializedName("organizationName") var organizationName: String,
    @SerializedName("organizationId") var organizationId: Int,
    @SerializedName("token") var token: String
)
