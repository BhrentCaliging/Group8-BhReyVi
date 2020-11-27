package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    lateinit var tv_go_login: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tv_go_login = findViewById(R.id.tv_go_to_login)
        tv_go_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}