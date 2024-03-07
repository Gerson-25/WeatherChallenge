package com.example.weatherchallenge.data.network

import android.provider.CallLog.Locations
import com.example.weatherchallenge.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather/realtime")
    suspend fun getWeather(
        @Query("location") locations: String,
        @Query("apikey") apiKey: String,
    ): Response<WeatherResponse>

}