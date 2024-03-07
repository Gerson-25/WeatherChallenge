package com.example.weatherchallenge.domain.di

import com.example.weatherchallenge.domain.repository.WeatherRepository
import com.example.weatherchallenge.domain.usecases.GetWeatherUseCase
import com.example.weatherchallenge.domain.usecases.GetWeatherUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {

    @Provides
    @Singleton
    fun providesGetWeatherUseCase(repository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCaseImpl(repository)
    }

}