package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    lateinit var tv_go_signup: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_go_signup = findViewById(R.id.tv_go_to_sign_up)
        tv_go_signup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}