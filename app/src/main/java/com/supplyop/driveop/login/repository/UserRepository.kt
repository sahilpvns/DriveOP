package com.supplyop.driveop.login.repository

import com.supplyop.driveop.login.api.method.LoginRequest
import com.supplyop.driveop.login.api.method.LoginResponse
import com.supplyop.driveop.login.api.method.UserApi
import retrofit2.Response

class UserRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }
}