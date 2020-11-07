package com.testo.api

import com.testo.pojo.UserRequest
import com.testo.pojo.UserResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("users")
    fun createUser(@Body userRequest: UserRequest): Single<UserResponse>
}