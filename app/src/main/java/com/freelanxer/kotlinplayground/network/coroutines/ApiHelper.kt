package com.freelanxer.kotlinplayground.network.coroutines

class ApiHelper(private val apiService: ApiService) {

    suspend fun getFeatureList(userName: String) = apiService.getFeatureList(userName)

}