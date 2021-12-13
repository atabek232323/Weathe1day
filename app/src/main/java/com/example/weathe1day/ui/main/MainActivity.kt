package com.example.weathe1day.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weathe1day.databinding.ActivityMainBinding
import com.example.weathe1day.repazitory.Repazitory
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mainViewModel : MainViewModel
    private lateinit var mainViewModelProvider : MainViewModelProvider
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMainViewModel()


        binding.btPoisk.setOnClickListener {
            getFromApi()



        }

    }


    private fun getFromApi() {

        val city = binding.edTxt.text.toString()
        mainViewModel.getWeather(city, "d55ba8262aa69505b4ef150260f1c450", "metric")
        mainViewModel.myWeather.observe(this, Observer {
            binding.apply {
                tvMax.text = it.body()!!.main.temp_max.toString() + "°C"
                tvSunrise.text = it.body()!!.sys.sunrise.toString()
                tVSanset.text = it.body()!!.sys.sunset.toString()
                text1010.text = it.body()!!.main.pressure.toString() + "mb"
                text81.text = it.body()!!.main.humidity.toString() + "%"
                text100.text = it.body()!!.main.grnd_level.toString() + "%"
                tvLittleCloud.text = it.body()!!.main.temp.toString() + "°C"
                tvMin.text = it.body()!!.main.temp_min.toString() + "°C"
                tvCountry.text = it.body()!!.sys.country.toString()
                tvCalifor.text = it.body()!!.name + ","
                textSw.text = it.body()!!.wind.speed.toString() + "m/s"
            }

        })
    }

    private fun initMainViewModel() {
        val repazitory = Repazitory()
        mainViewModelProvider = MainViewModelProvider(repazitory)

        mainViewModel =
            ViewModelProvider(this, mainViewModelProvider).get(MainViewModel::class.java)
    }
}