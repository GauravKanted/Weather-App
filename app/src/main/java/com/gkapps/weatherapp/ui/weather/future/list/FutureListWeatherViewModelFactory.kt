package com.gkapps.weatherapp.ui.weather.future.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gkapps.weatherapp.data.provider.UnitProvider
import com.gkapps.weatherapp.data.repository.WeatherRepository


class FutureListWeatherViewModelFactory(
    private val WeatherRepository: WeatherRepository,
    private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FutureListWeatherViewModel(
            WeatherRepository,
            unitProvider
        ) as T
    }
}