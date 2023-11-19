package com.example.pokdex

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()

    // Don't need this for our remote data source, we either succeed in our request of fail
    //data class Loading<out T>(val data: T? = null) : Resource<T>()
    data class Error<out T>(val message: String, val data: T? = null) : Resource<T>()
}
