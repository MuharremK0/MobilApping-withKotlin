package com.muharremk0.contextproject

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muharremk0.contextproject.databinding.ActivityMainBinding

//Store the username

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences
    var receivedUsername : String ? = null

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
        //SharedPreferences
        sharedPreferences = this.getSharedPreferences("com.muharremk0.contextproject",
            Context.MODE_PRIVATE)
        receivedUsername = sharedPreferences.getString("user","")

        if(receivedUsername!=null){
            binding.textView.text ="Saved username: ${receivedUsername}"
        }
    }

    fun save(view : View){
        val username=binding.editText.text.toString()
        if (username == ""){
            Toast.makeText(this,"Choose an username",Toast.LENGTH_LONG).show()
        }else{
            sharedPreferences.edit().putString("user",username).apply()
            binding.textView.text = "Saved username: ${username}"
        }
    }

    fun delete(view : View){
        receivedUsername = sharedPreferences.getString("user","")
        if(receivedUsername != null){
            binding.textView.text="Saved username:"
            sharedPreferences.edit().remove("user").apply()
        }
    }

}