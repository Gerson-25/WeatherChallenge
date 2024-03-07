package com.example.weatherchallenge.ui.weather.model

data class WeatherState<T>(
    val state: DataState? = null,
    val data: T? = null,
    val error: String = ""
)
