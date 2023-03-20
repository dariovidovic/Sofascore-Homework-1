package com.example.homework3

data class Cocktail(
    val name: String,
    val ingredients: String,
    val garnish: String,
    val description: String,
    val type: String,
    val glass: Glass,
    val picture_url: String
) {
    override fun toString(): String {
        return "Cocktail name: $name\n" +
                "Ingredients: $ingredients\n" +
                "Garnish: $garnish\n" +
                "Description: $description\n" +
                "Type of drink: $type\n" +
                "Serving glass: ${glass.toString()}"
    }
}

enum class Glass(val value: String) {
    Highball("Highball"),
    Collins("Collins"),
    Rocks("Rocks"),
    Martini("Martini"),
    Margarita("Margarita"),
    Shooter("Shooter");

    override fun toString(): String {
        return value
    }
}