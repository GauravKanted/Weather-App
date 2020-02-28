package com.gkapps.weatherapp.data.provider

import com.gkapps.weatherapp.data.db.entity.WeatherLocation


interface LocationProvider {
    suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation): Boolean
    suspend fun getPreferredLocationString(): String
}