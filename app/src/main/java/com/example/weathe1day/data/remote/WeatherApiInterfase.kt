package com.example.weathe1day.data.remote

import WeatherApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiInterfase {

    @GET("weather")
    suspend fun getWeather(@Query("q")q:String,@Query("appid")appid:String,@Query("units")units:String):Response<WeatherApi>


}
//https://api.openweathermap.org/data/2.5/weather?q=Bishkek&appid=d55ba8262aa69505b4ef150260f1c450