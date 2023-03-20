package com.example.homework3.ui.cabinet

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework3.Cocktail
import android.widget.TextView
import coil.load
import com.example.homework3.CollapsibleToolbarActivity
import com.example.homework3.R



class CocktailAdapter(private val cocktailList: MutableList<Cocktail>) :
    RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCocktail = cocktailList[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CollapsibleToolbarActivity::class.java)
            intent.putExtra("cocktail", currentCocktail)
            holder.itemView.context.startActivity(intent)
        }
        holder.cocktailName.text = currentCocktail.name
        holder.cocktailImage.load(currentCocktail.picture_url){
            error(R.drawable.ic_launcher_background)

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