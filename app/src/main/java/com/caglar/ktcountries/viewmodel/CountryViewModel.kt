package com.caglar.ktcountries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caglar.ktcountries.model.Country

class CountryViewModel(application: Application) : BaseViewModel(application) {
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom() {
        val country = Country("Asd","capital","region","language","try","www.sd.com")
        countryLiveData.value = country
    }
}