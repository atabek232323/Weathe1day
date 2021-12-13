package com.example.weathe1day.ui.main

import Weather
import WeatherApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathe1day.repazitory.Repazitory
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(val repazitory : Repazitory) : ViewModel() {
    val myWeather : MutableLiveData<Response<WeatherApi>> = MutableLiveData()
    fun getWeather(q : String, appid : String, units : String) {
        viewModelScope.launch {
            val rezult = repazitory.getWeather(q, appid, units)
            myWeather.value = rezult
        }
    }


}