package com.muharremk0.superherobook

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muharremk0.superherobook.databinding.ActivityMainBinding
import com.muharremk0.superherobook.databinding.RecyclerRowBinding

class RecyclerAdapter(val heroList : ArrayList<String>,val heroImages : ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.SuperHeroVH>() {
    class SuperHeroVH(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroVH {
        //Inflater,LayoutInflater,MenuInflater
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return SuperHeroVH(itemView)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: SuperHeroVH, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.recyclerViewTextView)
            .text=heroList.get(position)
        holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView.context,Introducing::class.java)
                intent.putExtra("superHeroName",heroList.get(position))
                intent.putExtra("superHeroImage",heroImages.get(position))
                /*
                val singleton = SingletonClass.chosenHero
                 singleton.img = heroImages.get(position)
                */
                holder.itemView.context.startActivity(intent)
            }
    }
}