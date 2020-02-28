package com.gkapps.weatherapp.ui.weather.future.detail

import androidx.lifecycle.ViewModel
import com.gkapps.weatherapp.data.provider.UnitProvider
import com.gkapps.weatherapp.data.repository.WeatherRepository
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
    detailDate: LocalDate,
    weatherRepository: WeatherRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    // TODO: Implement the ViewModel
}
