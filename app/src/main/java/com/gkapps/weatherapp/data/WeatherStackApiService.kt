package com.gkapps.weatherapp.data

import com.gkapps.weatherapp.BuildConfig
import com.gkapps.weatherapp.BuildConfig.API_KEY
import com.gkapps.weatherapp.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

var API_KEY_VALUE: String = BuildConfig.API_KEY

//Query URL: http://api.weatherstack.com/current?access_key=your_access_key&query=Chennai

interface WeatherStackApiService {

    @GET("current")
     fun getCurrentWeather(
        @Query("query") location: String
    ) : Deferred<CurrentWeatherResponse>

    companion object{
        operator fun invoke() : WeatherStackApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY_VALUE)
                    //.addQueryParameter("units","metric")
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherStackApiService::class.java)
        }
    }
}