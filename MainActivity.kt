package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hello Text = findViewById<TextView>(R.id.textHello) as TextView
        hello Text.setOnClickListener{
            Toast.makeText(this@MainActivity,"Hello Kotlin",Toast.LENGTH_SHORT).show()
        }
    }
}