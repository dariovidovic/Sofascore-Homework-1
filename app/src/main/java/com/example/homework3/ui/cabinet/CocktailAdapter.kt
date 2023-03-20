package com.example.homework3.ui.cabinet

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework3.Cocktail
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import coil.load
import coil.request.ImageRequest
import com.example.homework3.R
import java.io.File


class CocktailAdapter(private val cocktailList: MutableList<Cocktail>) :
    RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCocktail = cocktailList[position]
        holder.cocktailName.text = currentCocktail.name
        holder.cocktailImage.load(currentCocktail.picture_url){
            listener(onSuccess = { _, _ ->
                Log.d("Rezultat: ", "Uspjesno!")
            }, onError = { request: ImageRequest, throwable: Throwable ->
                // handle error here

                Log.d("Rezultat", "neuspjesno")
            })
        }

    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cocktailImage : ImageView = itemView.findViewById(R.id.cocktail_image)
        val cocktailName : TextView = itemView.findViewById(R.id.cocktail_name)
    }
}