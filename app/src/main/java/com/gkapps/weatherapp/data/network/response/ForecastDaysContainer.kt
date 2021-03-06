package com.gkapps.weatherapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.gkapps.weatherapp.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)