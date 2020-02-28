package com.gkapps.weatherapp.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.gkapps.weatherapp.data.provider.UnitProvider
import com.gkapps.weatherapp.data.repository.WeatherRepository
import com.gkapps.weatherapp.internal.lazyDeferred
import com.gkapps.weatherapp.ui.base.WeatherViewModel


class CurrentWeatherViewModel(
    private val WeatherRepository: WeatherRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(WeatherRepository, unitProvider) {

    val weather by lazyDeferred {
        WeatherRepository.getCurrentWeather(super.isMetricUnit)
    }
}
