package com.example.foractivities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ShowDiary: AppCompatActivity() {

    lateinit var date: EditText
    lateinit var intro: EditText
    lateinit var body: EditText
    lateinit var outro: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_diary)
        val handler = DiaryHelper(this)
        val entryList = handler.readDiaryEntry()

        date = findViewById(R.id.editDate)
        //date.setOnTouchListener() {}

        intro = findViewById(R.id.editIntro)

        body = findViewById(R.id.editBody)

        outro = findViewById(R.id.editOutro)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.side_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profile ->{
                startActivity(Intent(this, ProfileActivity::class.java))
                true
            }
            R.id.main ->{
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}