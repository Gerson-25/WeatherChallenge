package com.example.weatherchallenge.domain.repository

import com.example.weatherchallenge.domain.model.Weather
import com.example.weatherchallenge.domain.util.ResponseHandler

interface WeatherRepository {

    suspend fun getWeather(location:String):ResponseHandler<Weather>

}