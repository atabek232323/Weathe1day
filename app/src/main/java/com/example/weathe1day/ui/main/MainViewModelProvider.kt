package com.example.weathe1day.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weathe1day.repazitory.Repazitory

class MainViewModelProvider(val repazitory : Repazitory):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass : Class<T>) : T {
       return MainViewModel(repazitory) as T
    }
}