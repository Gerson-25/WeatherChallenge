package com.example.weatherchallenge.ui.weather.model

data class WeatherUI(
    val location: String = "",
    val temperature: String = "",
    val scale: Scale = Scale.CELSIUS
){
    fun getScaledTemperature(): String{
        return if (scale == Scale.CELSIUS)
            "$temperature C"
        else
            "$temperature F"
    }
}
