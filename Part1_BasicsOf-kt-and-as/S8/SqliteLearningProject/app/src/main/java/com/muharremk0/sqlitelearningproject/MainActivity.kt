package com.muharremk0.sqlitelearningproject

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        try {
            val database=this.openOrCreateDatabase("Products,", Context.MODE_PRIVATE,null)
        /*    database.execSQL("CREATE TABLE IF NOT EXISTS products(id INTEGER PRIMARY KEY, name VARCHAR,price INT)")
            database.execSQL("INSERT INTO products(name,price) VALUES ('Ayakkabi',100)")
            database.execSQL("INSERT INTO products(name,price) VALUES ('Elbise',150)")
            database.execSQL("INSERT INTO products(name,price) VALUES ('Tshirt',50)")
            database.execSQL("INSERT INTO products(name,price) VALUES ('Atki',200)")
            database.execSQL("INSERT INTO products(name,price) VALUES ('Bere',10)")
        */
            database.execSQL("DELETE FROM products WHERE id=5")
            database.execSQL("UPDATE products SET price = 250 WHERE name='Elbise'")

            val cursor = database.rawQuery("SELECT * FROM products",null)
            val idColumnIndex = cursor.getColumnIndex("id")
            val nameColumnIndex= cursor.getColumnIndex("name")
            val priceColumnIndex= cursor.getColumnIndex("price")

            while(cursor.moveToNext()){
                println("ID : ${cursor.getInt(idColumnIndex)}")
                println("Name : ${cursor.getString(nameColumnIndex)}")
                println("Price : ${cursor.getInt(priceColumnIndex)}")
            }
            cursor.close()
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}