package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class LoginActivity : AppCompatActivity() {
    lateinit var tv_go_signup: TextView
    lateinit var et_username: EditText
    lateinit var et_password: EditText
    lateinit var btn_confirm: Button
    lateinit var bar_progress: ProgressBar
    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        handler = DatabaseHelper(this)

        tv_go_signup = findViewById(R.id.tv_go_to_sign_up)
        tv_go_signup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        bar_progress = findViewById(R.id.login_progress)
        btn_confirm = findViewById(R.id.btn_confirm_login)
        btn_confirm.setOnClickListener {


            if(handler.userPresent(et_username.text.toString(), et_password.text.toString())){
                startActivity(Intent(this, MainActivity::class.java))
            }
            else if(et_username.text.toString().isNullOrEmpty() && et_password.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Credentials are incorrect", Toast.LENGTH_SHORT).show()
            }

        }
    }
}