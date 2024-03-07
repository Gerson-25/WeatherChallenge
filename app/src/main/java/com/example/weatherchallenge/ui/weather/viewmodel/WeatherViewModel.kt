package com.example.weatherchallenge.ui.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherchallenge.domain.usecases.GetWeatherUseCase
import com.example.weatherchallenge.domain.util.ResponseHandler
import com.example.weatherchallenge.ui.utils.toUI
import com.example.weatherchallenge.ui.weather.model.DataState
import com.example.weatherchallenge.ui.weather.model.Scale
import com.example.weatherchallenge.ui.weather.model.WeatherState
import com.example.weatherchallenge.ui.weather.model.WeatherUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {

    private val _uiSate = MutableLiveData<WeatherState<WeatherUI>>()
    val uiState: LiveData<WeatherState<WeatherUI>> = _uiSate


    fun getWeather(location:String){
        _uiSate.value = WeatherState(state = DataState.LOADING)
        viewModelScope.launch(Dispatchers.IO) {
            val response = getWeatherUseCase.invoke(location)
            withContext(Dispatchers.Main){
                when (response){
                   is ResponseHandler.Success<*> -> {
                       _uiSate.value = uiState.value?.copy(
                           state = DataState.SUCCESS,
                           data = response.data?.toUI() ?: WeatherUI()
                       )
                   }
                    is ResponseHandler.Error<*> -> {
                        _uiSate.value = uiState.value?.copy(
                            state = DataState.ERROR,
                            error = response.error
                        )
                    }
                    else -> {
                        _uiSate.value = uiState.value?.copy(
                            state = DataState.ERROR,
                            error = "Something went wrong"
                        )
                    }
                }
            }
        }
    }

    fun changeScale(to: Scale, temperature: String){
        val newTemperature = if (to == Scale.FARENHEIT){
            (temperature.toDouble() * 1.8) + 32
        } else {
            (temperature.toDouble() - 32) / 1.8
        }
        val newState = _uiSate.value?.data?.copy(
            temperature = String.format("%.1f", newTemperature),
            scale = to
        )

        _uiSate.value = _uiSate.value?.copy(
            data = newState
        )
    }
}