package com.freelanxer.kotlinplayground.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.freelanxer.kotlinplayground.model.FeatureListModel

class FeatureVM: BaseViewModel() {
    private val _featureListModel = MutableLiveData<FeatureListModel>()
    val featureListModel: LiveData<FeatureListModel> get() = _featureListModel

    fun getFeatureList(userName: String) {
        FeatureListModel.getFeature(userName, onResponse = {
                success: Boolean, featureListModel: FeatureListModel? ->
            _featureListModel.value = featureListModel
        })
    }
}