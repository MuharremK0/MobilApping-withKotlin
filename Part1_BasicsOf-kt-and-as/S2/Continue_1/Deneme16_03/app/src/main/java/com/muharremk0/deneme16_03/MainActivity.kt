package com.muharremk0.deneme16_03

import android.content.Intent
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

        println("called onCreate")
    }

    override fun onStart() {
        super.onStart()
        println("called onStart")
    }

    override fun onResume() {
        super.onResume()
        println("called onResume")
    }

    override fun onPause() {
        super.onPause()
        println("called onPause")
    }

    override fun onStop() {
        super.onStop()
        println("called onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("called onDestroy")
    }

    fun change_activity(view : View){
        val data=binding.editTextText!!.text.toString()
        val intent=Intent(applicationContext,SecondActivity::class.java)
        intent.putExtra("sended_data",data)
        startActivity(intent)
    }


}