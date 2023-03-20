package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.homework3.databinding.ActivityCollapsibleToolbarBinding
import java.util.*

@Suppress("DEPRECATION")
class CollapsibleToolbarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCollapsibleToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsible_toolbar)
        binding = ActivityCollapsibleToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val currentCocktail = intent.extras?.getSerializable("cocktail") as Cocktail
        binding.run {
            collapsingToolbarLayout.title = "Cheers!"
            collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsed_toolbar_title)
            collapsingToolbarLayout.setExpandedTitleColor(R.style.expanded_toolbar_title)
            cocktailName.text = "Cocktail name: " + currentCocktail.name
            cocktailIngredients.text = "Cocktail ingredients: " + currentCocktail.ingredients
            cocktailGarnish.text = "Cocktail garnish: " + currentCocktail.garnish
            cocktailDescription.text = "Cocktail preparation: " + currentCocktail.description
            cocktailType.text = "Cocktail type: " + currentCocktail.type
            cocktailGlass.text = "Cocktail glass: " + currentCocktail.glass
            cocktailImage.load(currentCocktail.picture_url){
                error(R.drawable.ic_launcher_background)
            }
        }

    }
}