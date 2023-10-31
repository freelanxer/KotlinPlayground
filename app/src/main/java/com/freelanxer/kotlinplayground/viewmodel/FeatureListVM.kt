package com.freelanxer.kotlinplayground.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.freelanxer.kotlinplayground.network.coroutines.BaseRepository
import com.freelanxer.kotlinplayground.network.coroutines.Resource
import kotlinx.coroutines.Dispatchers

class FeatureListVM(private val baseRepository: BaseRepository): ViewModel() {

    fun getFeatureList(userName: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = baseRepository.getFeatureList(userName)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error"))
        }
    }
}