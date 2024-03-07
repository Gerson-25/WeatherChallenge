package com.example.weatherchallenge.ui.utils

import com.example.weatherchallenge.domain.model.Weather
import com.example.weatherchallenge.ui.weather.model.WeatherUI

fun Weather.toUI(): WeatherUI {
    return WeatherUI(
        temperature = temperature.toString(),
        location = location.split(",")[0]
    )
}