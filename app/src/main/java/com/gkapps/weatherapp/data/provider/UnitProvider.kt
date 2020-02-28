package com.gkapps.weatherapp.data.provider

import com.gkapps.weatherapp.internal.UnitSystem


interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}