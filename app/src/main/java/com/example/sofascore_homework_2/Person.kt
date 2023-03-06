package com.example.sofascore_homework_2

data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val oib: Int,
    val birthPlace: String,
    val currentOccupation: String,
    val favouriteMovie: String,
    val favouriteTvShow: String,
    val favouriteFood: String,
    val favouriteSong: String
) {
    override fun toString(): String {
        return "$firstName, $lastName, $age, $oib, $birthPlace," +
                "$currentOccupation, $favouriteMovie, $favouriteTvShow, $favouriteFood, $favouriteSong\n"
    }
}
