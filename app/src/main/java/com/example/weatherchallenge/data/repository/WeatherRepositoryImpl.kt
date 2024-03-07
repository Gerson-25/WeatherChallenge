package com.example.weatherchallenge.data.repository

import com.example.weatherchallenge.domain.datasource.WeatherDataSource
import com.example.weatherchallenge.domain.model.Weather
import com.example.weatherchallenge.domain.repository.WeatherRepository
import com.example.weatherchallenge.domain.util.ResponseHandler
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val dataSource: WeatherDataSource
): WeatherRepository {
    override suspend fun getWeather(location:String): ResponseHandler<Weather> {
        return dataSource.getWeather(location)
    }
}