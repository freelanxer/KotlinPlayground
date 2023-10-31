package com.freelanxer.kotlinplayground.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.freelanxer.kotlinplayground.model.FeatureListModel
import com.freelanxer.kotlinplayground.network.ApiResult
import com.freelanxer.kotlinplayground.network.coroutines.BaseRepository
import com.freelanxer.kotlinplayground.network.coroutines.Resource
import com.freelanxer.kotlinplayground.network.coroutines.Status
import kotlinx.coroutines.Dispatchers

class FeatureListVM(private val baseRepository: BaseRepository): ViewModel() {
    private var _featureList = MutableLiveData<ApiResult<FeatureListModel>?>()
    val featureList: LiveData<ApiResult<FeatureListModel>?> get() = _featureList

    fun getFeatureList(owner: LifecycleOwner, userName: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = baseRepository.getFeatureList(userName)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error"))
        }
    }.observe(owner) {
        it?.let { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    _featureList.value = resource.data
                }

                Status.LOADING -> {

                }

                Status.ERROR -> {

                }
            }

        }
    }

}