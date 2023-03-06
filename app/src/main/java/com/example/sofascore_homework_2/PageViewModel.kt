package com.example.sofascore_homework_2
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PageViewModel : ViewModel() {

    private val liveData = MutableLiveData<List<Person>>(emptyList())

    fun getLiveData() : LiveData<List<Person>>{
        return liveData
    }

    fun addPerson(
        firstName: String,
        lastName: String,
        age: Int,
        oib: Int,
        birthPlace: String,
        currentOccupation: String,
        favouriteMovie: String,
        favouriteTvShow: String,
        favouriteFood: String,
        favouriteSong: String
    ) {
        val person = Person(
            firstName,
            lastName,
            age,
            oib,
            birthPlace,
            currentOccupation,
            favouriteMovie,
            favouriteTvShow,
            favouriteFood,
            favouriteSong
        )
        val list = liveData.value?.toMutableList()
        list?.add(person)
        liveData.value = list

    }
}
