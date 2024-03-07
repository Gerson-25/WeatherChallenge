package com.example.weatherchallenge.domain.di

import com.example.weatherchallenge.data.datasource.WeatherDataSourceImpl
import com.example.weatherchallenge.data.network.WeatherApi
import com.example.weatherchallenge.domain.datasource.WeatherDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideWeatherDataSource(api: WeatherApi): WeatherDataSource {
        return WeatherDataSourceImpl(api)
    }

}