package com.gkapps.weatherapp.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gkapps.weatherapp.data.provider.UnitProvider
import com.gkapps.weatherapp.data.repository.WeatherRepository


class CurrentWeatherViewModelFactory(
    private val WeatherRepository: WeatherRepository,
    private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(WeatherRepository, unitProvider) as T
    }
}