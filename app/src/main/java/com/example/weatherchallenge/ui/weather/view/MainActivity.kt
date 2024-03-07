package com.example.weatherchallenge.ui.weather.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.example.weatherchallenge.R
import com.example.weatherchallenge.databinding.ActivityMainBinding
import com.example.weatherchallenge.ui.weather.model.DataState
import com.example.weatherchallenge.ui.weather.model.Scale
import com.example.weatherchallenge.ui.weather.viewmodel.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel.getWeather("San Salvador")

        viewModel.uiState.observe(this){ state ->
            when(state.state){
                DataState.LOADING -> {
                    binding.changeScale.isEnabled = false
                    binding.progressBar.visibility = View.VISIBLE
                }
                DataState.SUCCESS -> {
                    binding.changeScale.isEnabled = true
                    binding.progressBar.visibility = View.GONE
                    binding.temperatureTextView.text = state.data?.getScaledTemperature()
                    binding.cityTextView.text = state.data?.location

                    binding.changeScale.setOnClickListener {
                        val changeTo = if(state.data?.scale == Scale.CELSIUS) Scale.FARENHEIT else Scale.CELSIUS
                        viewModel.changeScale(changeTo, state.data?.temperature ?: "")
                        it.clearFocus()
                    }
                }
                DataState.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, state.error, Toast.LENGTH_SHORT).show()
                }

                else -> {binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()}
            }
        }

        binding.textInputLayout.setEndIconOnClickListener {
            val city = binding.searchByCity.text.toString()
            viewModel.getWeather(city)
        }

        setContentView(binding.root)
    }


}