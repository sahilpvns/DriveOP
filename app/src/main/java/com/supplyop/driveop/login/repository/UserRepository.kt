package com.supplyop.driveop.login.repository

import com.supplyop.driveop.login.network.LoginRequest
import com.supplyop.driveop.login.network.LoginResponse
import com.supplyop.driveop.login.network.UserApi
import retrofit2.Response

class UserRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }
}