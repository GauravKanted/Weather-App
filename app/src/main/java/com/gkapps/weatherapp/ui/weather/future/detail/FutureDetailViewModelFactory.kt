package com.gkapps.weatherapp.ui.weather.future.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gkapps.weatherapp.data.provider.UnitProvider
import com.gkapps.weatherapp.data.repository.WeatherRepository
import org.threeten.bp.LocalDate


class FutureDetailWeatherViewModelFactory(
    private val detailDate: LocalDate,
    private val weatherRepository: WeatherRepository,
    private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FutureDetailWeatherViewModel(detailDate, weatherRepository, unitProvider) as T
    }
}