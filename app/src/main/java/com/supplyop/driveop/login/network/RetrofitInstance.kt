package com.supplyop.driveop.login.network

import com.google.gson.GsonBuilder
import com.supplyop.driveop.login.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    var BASE_URL: String = "https://private-a27f13-sahilprajapati1.apiary-mock.com/"

    var mHttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var mOkHttpClient = OkHttpClient.Builder().addInterceptor(mHttpLoggingInterceptor).build()
    var mRetrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder().baseUrl(Constant.BASE_URL).client(mOkHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return mRetrofit
        }

    val getClient: UserApi
        get() {

            val gson = GsonBuilder().setLenient().create()
            val interceptor = HttpLoggingInterceptor()

            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val builder = Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create(gson)).build()
            return builder.create(UserApi::class.java)
        }

}