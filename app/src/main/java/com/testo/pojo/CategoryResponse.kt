package com.testo.pojo

import com.google.gson.annotations.Expose

data class CategoryResponse(
    @Expose
    var categoryId: Long,
    @Expose
    var categoryName: String,
    @Expose
    var categoryImg: String
)