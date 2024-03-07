package com.example.weatherchallenge.domain.usecases

import com.example.weatherchallenge.data.model.Location
import com.example.weatherchallenge.domain.model.Weather
import com.example.weatherchallenge.domain.repository.WeatherRepository
import com.example.weatherchallenge.domain.util.ResponseHandler
import java.nio.channels.spi.AbstractSelectionKey
import javax.inject.Inject

class GetWeatherUseCaseImpl @Inject constructor(
    private val repository: WeatherRepository
): GetWeatherUseCase {
    override suspend fun invoke(location: String): ResponseHandler<Weather> {
        return repository.getWeather(location)
    }
}