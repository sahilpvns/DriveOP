package com.supplyop.driveop.ui.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var BASE_URL: String = "https://private-a27f13-sahilprajapati1.apiary-mock.com/"
    val getClient: Api
        get() {
            val gson = GsonBuilder().setLenient().create()

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val builder = Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create(gson)).build()

            return builder.create(Api::class.java)
        }
}