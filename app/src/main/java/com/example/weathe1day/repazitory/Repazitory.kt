package com.example.weathe1day.repazitory

import WeatherApi
import com.example.weathe1day.data.remote.RetrofitObjek
import retrofit2.Response

class Repazitory {
    suspend fun getWeather(q : String, appid : String, units:String) : Response<WeatherApi> {
        return RetrofitObjek.api.getWeather(q, appid,units)
    }


}