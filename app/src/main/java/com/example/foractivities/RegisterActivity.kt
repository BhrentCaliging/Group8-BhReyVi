package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class RegisterActivity : AppCompatActivity() {
    lateinit var tv_go_login: TextView
    lateinit var et_username: EditText
    lateinit var et_password: EditText
    lateinit var btn_confirm: Button
    lateinit var bar_progress: ProgressBar
    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        handler = DatabaseHelper(this)

        tv_go_login = findViewById(R.id.tv_go_to_login)
        tv_go_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        et_username = findViewById(R.id.et_username_signup)
        et_password = findViewById(R.id.et_password_signup)
        btn_confirm = findViewById(R.id.btn_confirm_signup)
        bar_progress = findViewById(R.id.signup_progress)

        btn_confirm.setOnClickListener {

            if(et_username.text.toString().isNotEmpty() && et_password.text.toString().isNotEmpty()) {
                handler.insertUserData(et_username.text.toString(), et_password.text.toString())
                Toast.makeText(this, "Sign up Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            }
            else if(et_username.text.toString().isNullOrEmpty() && et_password.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "Please fill up credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}