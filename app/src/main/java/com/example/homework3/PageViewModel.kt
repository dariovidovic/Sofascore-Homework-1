package com.example.homework3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageViewModel : ViewModel() {

    private val liveData = MutableLiveData<List<Cocktail>>()
    val _liveData: LiveData<List<Cocktail>> = liveData

    fun getLiveData(): LiveData<List<Cocktail>> {
        return liveData
    }

    fun addCocktail(cocktail: Cocktail) {
        val list = _liveData.value?.toMutableList() ?: arrayListOf()
        list.add(cocktail)
        liveData.value = list
    }


}