package com.freelanxer.kotlinplayground.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.freelanxer.kotlinplayground.model.FeatureListModel
import com.freelanxer.kotlinplayground.network.ApiResult
import com.freelanxer.kotlinplayground.network.Callback
import com.freelanxer.kotlinplayground.network.FeatureRepository
import com.freelanxer.kotlinplayground.network.RetrofitManager

class FeatureVM: BaseViewModel() {
    private val _featureListModel = MutableLiveData<FeatureListModel>()
    val featureListModel: LiveData<FeatureListModel> get() = _featureListModel

    fun getFeatureList(userName: String) {
        val repository = FeatureRepository(RetrofitManager().service)
        repository.getFeatureList(userName, object: Callback<ApiResult<FeatureListModel>>{
            override fun onSuccess(response: ApiResult<FeatureListModel>?) {
                _featureListModel.value = response?.value
            }

            override fun onError(error: Throwable?) {

            }
        })
    }
}