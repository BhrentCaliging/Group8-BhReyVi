package com.example.foractivities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.foractivities.handlers.DiaryHandler
import com.example.foractivities.handlers.ScriptHandler
import com.example.foractivities.models.Diary

class DiaryAddActivity : AppCompatActivity() {

    lateinit var et_date: EditText
    lateinit var et_intro: EditText
    lateinit var et_body: EditText
    lateinit var et_outro: EditText
    lateinit var save: TextView
    lateinit var diaryHandler: DiaryHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_add)

        et_date = findViewById(R.id.addDate)
        et_intro = findViewById(R.id.addIntro)
        et_body = findViewById(R.id.addBody)
        et_outro = findViewById(R.id.addOutro)
        diaryHandler = DiaryHandler()

        save = findViewById(R.id.addSave)
        save.setOnClickListener{

            val date = et_date.text.toString()
            val intro = et_intro.text.toString()
            val body = et_body.text.toString()
            val outro = et_outro.text.toString()

            val diary = Diary(date = date, intro = intro, body = body, outro = outro)

            if(et_date.text.toString().isNotEmpty() && et_intro.text.toString().isNotEmpty() && et_body.text.toString().isNotEmpty() && et_outro.text.toString().isNotEmpty()) {
                diaryHandler.create(diary)
                Toast.makeText(this, "Entry Added to Diary", Toast.LENGTH_SHORT).show()
                clearFields()
            }
            else{
                Toast.makeText(this, "Fill Up All Fields", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun clearFields() {
        et_date.text.clear()
        et_intro.text.clear()
        et_body.text.clear()
        et_outro.text.clear()
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
            R.id.recents ->{
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}