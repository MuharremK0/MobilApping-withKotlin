package com.muharremk0.handlerrunnableproject

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muharremk0.handlerrunnableproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var num = 0
    var runnable : Runnable = Runnable{}
    var handler = Handler(Looper.myLooper()!!)

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

    fun start(view : View){
        runnable=object : Runnable{
            override fun run() {
                num+=1
                binding.textView.text="Counter: ${num}"
                handler.postDelayed(runnable,1000)
            }
        }
        handler.post(runnable)
    }

    fun stop(view : View){
        handler.removeCallbacks(runnable)
        num=0
        binding.textView.text="Sayaç: 0"
    }
}