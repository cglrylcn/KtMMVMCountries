package com.caglar.ktcountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caglar.ktcountries.model.Country

class CountryViewModel : ViewModel() {
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom() {
        val country = Country("Asd","capital","region","language","try","www.sd.com")
        countryLiveData.value = country
    }
}