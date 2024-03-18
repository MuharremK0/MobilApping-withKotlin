package com.muharremk0.contextproject

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muharremk0.contextproject.databinding.ActivityMainBinding

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

        //Toast,Alert
        //applicationContext -> app cpntext
        //this, this@MainActivity -> context of activity

        Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show()
    }

    fun show_m(view: View){
        val attentionMessage=AlertDialog.Builder(this@MainActivity)
        attentionMessage.setTitle("Password Error")
        attentionMessage.setMessage("You didn't enter the password, can you try to enter again ?")
        //Demonstration of Lambda
        attentionMessage.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(this,"You're trying again.",Toast.LENGTH_LONG).show()
        })
        attentionMessage.setNegativeButton("No"){dialogInterface,i ->
            Toast.makeText(this,"You chose no,you're not trying.",Toast.LENGTH_LONG).show()
        }
        attentionMessage.show()

    }
}