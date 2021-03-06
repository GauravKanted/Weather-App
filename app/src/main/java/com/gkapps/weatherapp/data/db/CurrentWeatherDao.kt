package com.gkapps.weatherapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gkapps.weatherapp.data.db.entity.CURRENT_ID
import com.gkapps.weatherapp.data.db.entity.CurrentWeatherEntry
import com.gkapps.weatherapp.data.db.unitlocalized.current.ImperialCurrentWeatherEntry
import com.gkapps.weatherapp.data.db.unitlocalized.current.MetricCurrentWeatherEntry


@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}