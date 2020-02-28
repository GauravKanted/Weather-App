package com.gkapps.weatherapp.ui.base

import androidx.lifecycle.ViewModel
import com.gkapps.weatherapp.data.provider.UnitProvider
import com.gkapps.weatherapp.data.repository.WeatherRepository
import com.gkapps.weatherapp.internal.UnitSystem
import com.gkapps.weatherapp.internal.lazyDeferred


abstract class WeatherViewModel(
    private val WeatherRepository: WeatherRepository,
    unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        WeatherRepository.getWeatherLocation()
    }
}