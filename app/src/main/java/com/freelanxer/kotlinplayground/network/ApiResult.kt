package com.freelanxer.kotlinplayground.network

import com.squareup.moshi.Json

data class ApiResult<T>(
    @field:Json(name = "token") val token: String,
    @field:Json(name = "success") val success: Boolean,
    @field:Json(name = "message") val message: String,
    @field:Json(name = "value") val value: T,
)
