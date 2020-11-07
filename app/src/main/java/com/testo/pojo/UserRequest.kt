package com.testo.pojo

import com.google.gson.annotations.Expose

data class UserRequest(
    @Expose
    var firstName: String,
    @Expose
    var lastName: String?,
    @Expose
    var email: String,
    @Expose
    var password: String
)