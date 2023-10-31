package com.freelanxer.kotlinplayground.network.coroutines

class BaseRepository(private val apiHelper: ApiHelper) {
    suspend fun getFeatureList(userName: String) = apiHelper.getFeatureList(userName)
}