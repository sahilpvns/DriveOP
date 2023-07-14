package com.supplyop.driveop.login.network

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username") var username: String,
    @SerializedName("password") var password: String
)