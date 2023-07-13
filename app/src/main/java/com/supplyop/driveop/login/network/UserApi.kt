package com.supplyop.driveop.login.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    companion object {
        fun getApi(): UserApi? {
            return RetrofitInstance.client?.create(UserApi::class.java) }
    }

    @POST("https://gateway.supplyop.com/supply-op/login/genrate-token")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("shipmentCurrent")
    fun getShipmentCurrentList(): Call<List<ShipmentResponse>>

    @GET("shipmentCompleted")
    fun getShipmentCompletedList(): Call<List<ShipmentResponse>>
}