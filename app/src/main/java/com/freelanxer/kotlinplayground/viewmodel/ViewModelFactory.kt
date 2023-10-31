package com.freelanxer.kotlinplayground.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.freelanxer.kotlinplayground.network.coroutines.ApiHelper
import com.freelanxer.kotlinplayground.network.coroutines.BaseRepository

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FeatureListVM::class.java)) {
            return FeatureListVM(BaseRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}