package com.freelanxer.kotlinplayground.network

import com.freelanxer.kotlinplayground.model.FeatureListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("Feature/GetFeatureList")
    fun getFeatureList(@Query("userName") userName: String): Call<ApiResult<FeatureListModel>>

}