package com.example.weatherchallenge.domain.usecases

import com.example.weatherchallenge.domain.model.Weather
import com.example.weatherchallenge.domain.util.ResponseHandler

interface GetWeatherUseCase {

    suspend operator fun invoke(location: String): ResponseHandler<Weather>

}