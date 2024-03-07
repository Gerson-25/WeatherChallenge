package com.example.weatherchallenge.domain.di

import com.example.weatherchallenge.data.repository.WeatherRepositoryImpl
import com.example.weatherchallenge.domain.datasource.WeatherDataSource
import com.example.weatherchallenge.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideWeatherRepository(dataSource: WeatherDataSource): WeatherRepository {
        return WeatherRepositoryImpl(dataSource)
    }
}