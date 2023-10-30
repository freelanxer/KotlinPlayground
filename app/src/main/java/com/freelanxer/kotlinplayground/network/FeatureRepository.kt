package com.freelanxer.kotlinplayground.network

import com.freelanxer.kotlinplayground.model.FeatureListModel

class FeatureRepository(private var service: ApiService): BaseRepository() {

    fun getFeatureList(userName: String, callback: Callback<ApiResult<FeatureListModel>>) {
        service.getFeatureList(userName).makeCall {
            onResponseSuccess = {
                callback.onSuccess(it.body())
            }
            onResponseFailure = {
                callback.onError(it)
            }
        }
    }

}