package com.example.weatherchallenge.domain.util

import androidx.lifecycle.LiveData

sealed class ResponseHandler<T>(
    val data: T? = null,
    val error: String = ""
) {
    class Loading<T>: ResponseHandler<T>()
    class Success<T>(data: T?): ResponseHandler<T>(data)
    class Error<T>(error: String): ResponseHandler<T>(error = error)
}