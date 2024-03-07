package com.example.weatherchallenge.domain.util

import com.example.weatherchallenge.data.model.WeatherResponse
import com.example.weatherchallenge.domain.model.Weather

fun WeatherResponse.toDomain(): Weather {
    return Weather(
        temperature = data.values.temperature,
        location = location.name
    )
}