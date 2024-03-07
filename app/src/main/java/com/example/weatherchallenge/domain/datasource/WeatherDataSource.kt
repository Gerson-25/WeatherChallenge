package com.example.weatherchallenge.domain.datasource

import com.example.weatherchallenge.domain.model.Weather
import com.example.weatherchallenge.domain.util.ResponseHandler
import retrofit2.Response

interface WeatherDataSource {

    suspend fun getWeather(location: String): ResponseHandler<Weather>

}