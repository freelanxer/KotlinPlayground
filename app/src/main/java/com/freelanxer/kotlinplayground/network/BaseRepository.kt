package com.freelanxer.kotlinplayground.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseRepository {

    fun<T> Call<T>.makeCall(callback: BaseCallback<T>.() -> Unit) {
        val callBackKt = BaseCallback<T>()
        callback.invoke(callBackKt)
        this.enqueue(callBackKt)
    }

    class BaseCallback<T>: Callback<T> {
        var onResponseSuccess: ((Response<T>) -> Unit)? = null
        var onResponseFailure: ((error: Throwable?) -> Unit)? = null

        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful)
                onResponseSuccess?.invoke(response)
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            onResponseFailure?.invoke(t)
        }

    }

}