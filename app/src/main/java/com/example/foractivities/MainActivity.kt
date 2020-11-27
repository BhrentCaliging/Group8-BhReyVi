package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btn_recent: Button
    lateinit var btn_diary: Button
    lateinit var btn_book: Button
    lateinit var btn_script: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_recent = findViewById(R.id.btn_recents)
        btn_recent.setOnClickListener {  }

        btn_diary = findViewById(R.id.btn_diary)
        btn_diary.setOnClickListener {
            startActivity(Intent(this, DiaryActivity::class.java))
        }

        btn_book = findViewById(R.id.btn_books)
        btn_book.setOnClickListener {
            startActivity(Intent(this, BookActivity::class.java))
        }

        btn_script = findViewById(R.id.btn_scripts)
        btn_script.setOnClickListener {
            startActivity(Intent(this, ScriptActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profile ->{
                startActivity(Intent(this, ProfileActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}