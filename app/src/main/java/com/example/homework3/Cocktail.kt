package com.example.homework3

data class Cocktail(
    val name: String,
    val ingredients: String,
    val garnish: String,
    val description: String,
    val type: String,
    val glass: String
) {
    override fun toString(): String {
        return  "Cocktail name: $name\n" +
                "Ingredients: $ingredients\n" +
                "Garnish: $garnish\n" +
                "Description: $description\n" +
                "Type of drink: $type\n" +
                "Serving glass: $glass"
    }
}

enum class glass{
        HIGHBALL, COLLINS, ROCKS, MARTINI, MARGARITA, SHOOTER
}