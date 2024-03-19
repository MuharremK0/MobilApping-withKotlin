package com.muharremk0.superherobook

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.muharremk0.superherobook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Data Preparing
        var superHeroNames=ArrayList<String>()
        superHeroNames.add("Batman")
        superHeroNames.add("Superman")
        superHeroNames.add("Ironman")
        superHeroNames.add("Aquaman")
        superHeroNames.add("Spiderman")

        //Unefficient way
        /*
        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.indir2)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.indir1)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.indir5)
        val aquamanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.indir4)
        val spidermanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.indir3)

        var superHeroImages = ArrayList<Bitmap>()
        superHeroImages.add(batmanBitmap)
        superHeroImages.add(supermanBitmap)
        superHeroImages.add(ironmanBitmap)
        superHeroImages.add(aquamanBitmap)
        superHeroImages.add(spidermanBitmap)
        */

        //Efficient way
        val batmanDrawableId=R.drawable.indir2
        val supermanDrawableId=R.drawable.indir1
        val ironmanDrawableId=R.drawable.indir5
        val aquamanDrawableId=R.drawable.indir4
        val spidermanDrawableId=R.drawable.indir3

        var superHeroDrawableList = ArrayList<Int>()
        superHeroDrawableList.add(batmanDrawableId)
        superHeroDrawableList.add(supermanDrawableId)
        superHeroDrawableList.add(ironmanDrawableId)
        superHeroDrawableList.add(aquamanDrawableId)
        superHeroDrawableList.add(spidermanDrawableId)

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        val adapter = RecyclerAdapter(superHeroNames,superHeroDrawableList)
        binding.recyclerView.adapter=adapter
    }
}