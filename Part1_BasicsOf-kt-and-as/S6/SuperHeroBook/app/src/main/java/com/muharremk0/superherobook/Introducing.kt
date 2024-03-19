package com.muharremk0.superherobook

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muharremk0.superherobook.databinding.ActivityIntroducingBinding

class Introducing : AppCompatActivity() {
    lateinit var binding: ActivityIntroducingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityIntroducingBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent=intent
        val chosenHeroName=intent.getStringExtra("superHeroName")
        binding.textView.text=chosenHeroName

        val chosenHeroImage=intent.getIntExtra("superHeroImage",0)
        val bitmap=BitmapFactory.decodeResource(applicationContext.resources,chosenHeroImage)
        binding.imageView.setImageBitmap(bitmap)

        /*
        val chosenHero = SingletonClass.chosenHero
        val chosenImage = chosenHero.img
        binding.imageView.setImageBitmap(chosenImage)
         */
    }
}