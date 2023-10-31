package com.freelanxer.kotlinplayground.network.coroutines

import com.freelanxer.kotlinplayground.model.FeatureListModel
import com.freelanxer.kotlinplayground.network.ApiResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("Feature/GetFeatureList")
    suspend fun getFeatureList(@Query("userName") userName: String): ApiResult<FeatureListModel>

}