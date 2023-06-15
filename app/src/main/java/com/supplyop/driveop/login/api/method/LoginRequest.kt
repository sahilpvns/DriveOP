package com.supplyop.driveop.login.api.method

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username") var email: String,
    @SerializedName("password") var password: String
)