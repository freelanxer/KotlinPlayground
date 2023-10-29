package com.freelanxer.kotlinplayground.network

interface Callback<T> {
    fun onSuccess(response: T?)
    fun onError(error: Throwable?)
}