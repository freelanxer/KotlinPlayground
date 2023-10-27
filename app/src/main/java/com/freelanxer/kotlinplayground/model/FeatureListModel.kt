package com.freelanxer.kotlinplayground.model

import com.freelanxer.kotlinplayground.network.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class FeatureListModel(
    val featureList: List<FeatureModel>
) {

    companion object {
        fun getFeature(userName: String, onResponse: (Boolean, FeatureListModel?) -> Unit) {
            val retrofitManager = RetrofitManager()
            val call = retrofitManager.service.getDemoList(userName)
            call.enqueue(object : Callback<FeatureListModel> {
                override fun onResponse(
                    call: Call<FeatureListModel>,
                    response: Response<FeatureListModel>
                ) {
                    val model = response.body()
                    onResponse(true, model)
                }

                override fun onFailure(call: Call<FeatureListModel>, t: Throwable) {
                    onResponse(false, null)
                }
            })
        }
    }

}
