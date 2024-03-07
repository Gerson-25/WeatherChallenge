package com.example.weatherchallenge.data.datasource

import com.example.weatherchallenge.BuildConfig
import com.example.weatherchallenge.data.network.WeatherApi
import com.example.weatherchallenge.domain.datasource.WeatherDataSource
import com.example.weatherchallenge.domain.model.Weather
import com.example.weatherchallenge.domain.util.ResponseHandler
import com.example.weatherchallenge.domain.util.toDomain

class WeatherDataSourceImpl(
    private val api: WeatherApi
): WeatherDataSource {
    override suspend fun getWeather(location: String): ResponseHandler<Weather> {
        try {
            val response = api.getWeather(location, BuildConfig.API_KEY)
            return if (response.isSuccessful){
                ResponseHandler.Success(response.body()?.toDomain())
            } else {
                ResponseHandler.Error(response.errorBody()?.string() ?: "Something went wrong")
            }
        } catch (e: Throwable) {
            return ResponseHandler.Error(e.message.toString())
        }
    }
}