package com.example.weatherchallenge.data.model


data class WeatherResponse(
    val data: Data,
    val location: Location
)

data class Data(
    val time: String,
    val values: Values
)

data class Values(
    val cloudBase: Double,
    val cloudCeiling: Double,
    val cloudCover: Int,
    val dewPoint: Double,
    val freezingRainIntensity: Int,
    val humidity: Int,
    val precipitationProbability: Int,
    val pressureSurfaceLevel: Double,
    val rainIntensity: Int,
    val sleetIntensity: Int,
    val snowIntensity: Int,
    val temperature: Double,
    val temperatureApparent: Double,
    val uvHealthConcern: Int,
    val uvIndex: Int,
    val visibility: Double,
    val weatherCode: Int,
    val windDirection: Double,
    val windGust: Double,
    val windSpeed: Double
)

data class Location(
    val lat: Double,
    val lon: Double,
    val name: String,
    val type: String
)
