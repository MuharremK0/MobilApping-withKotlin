package com.muharremk0.deneme16_03

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muharremk0.deneme16_03.databinding.ActivityMainBinding


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

    }

    fun create_hero(view : View){
        var name = binding.editTextText1.text.toString()
        var age = binding.editTextText2.text.toString().toIntOrNull()
        var job = binding.editTextText3.text.toString()


        if(age!=null){
            val sh=SuperHero(name,age,job)
            binding.txt.text = "Name : ${sh.name} Age : ${sh.age} Job : ${sh.job}"
        }else{
            binding.txt.text = "Enter your age correctly."
        }

    }
}