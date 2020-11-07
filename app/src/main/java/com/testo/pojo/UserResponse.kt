package com.testo.pojo

import com.google.gson.annotations.Expose

data class UserResponse(
    @Expose
    val userId: Long,
    @Expose
    val firstName: String,
    @Expose
    val lastName: String?,
    @Expose
    val email: String,
    @Expose
    val emailVerificationStatus: String
)