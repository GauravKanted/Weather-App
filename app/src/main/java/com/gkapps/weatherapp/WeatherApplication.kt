package com.gkapps.weatherapp


import android.app.Application
import android.content.Context
import com.gkapps.weatherapp.data.network.WeatherStackApiService
import com.google.android.gms.location.LocationServices
import com.jakewharton.threetenabp.AndroidThreeTen
import com.gkapps.weatherapp.data.db.ForecastDatabase
import com.gkapps.weatherapp.data.network.*
import com.gkapps.weatherapp.data.provider.LocationProvider
import com.gkapps.weatherapp.data.provider.LocationProviderImpl
import com.gkapps.weatherapp.data.provider.UnitProvider
import com.gkapps.weatherapp.data.provider.UnitProviderImpl
import com.gkapps.weatherapp.data.repository.WeatherRepository
import com.gkapps.weatherapp.data.repository.WeatherRepositoryImpl
import com.gkapps.weatherapp.ui.weather.current.CurrentWeatherViewModelFactory
import com.gkapps.weatherapp.ui.weather.future.detail.FutureDetailWeatherViewModelFactory
import com.gkapps.weatherapp.ui.weather.future.list.FutureListWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*
import org.threeten.bp.LocalDate


class WeatherApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@WeatherApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().futureWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton {
            WeatherStackApiService(
                instance()
            )
        }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<WeatherRepository>() with singleton {
            WeatherRepositoryImpl(
                instance(),
                instance(),
                instance(),
                instance(),
                instance()
            )
        }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
        bind() from provider { FutureListWeatherViewModelFactory(instance(), instance()) }
        bind() from factory { detailDate: LocalDate ->
            FutureDetailWeatherViewModelFactory(
                detailDate,
                instance(),
                instance()
            )
        }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}