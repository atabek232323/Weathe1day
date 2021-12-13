package com.example.weathe1day.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitObjek {
    val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api by lazy {
     retrofit.create(WeatherApiInterfase::class.java)
    }

}