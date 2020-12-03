package com.example.foractivities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.foractivities.handlers.DiaryHandler
import com.example.foractivities.models.Diary

class DiaryAddActivity : AppCompatActivity() {

    lateinit var date: EditText
    lateinit var intro: EditText
    lateinit var body: EditText
    lateinit var outro: EditText
    lateinit var save: TextView
    lateinit var  diaryHandler: DiaryHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_diary)

        date = findViewById(R.id.editDate)
        intro = findViewById(R.id.editIntro)
        body = findViewById(R.id.editBody)
        outro = findViewById(R.id.editOutro)

        save = findViewById(R.id.save)
        save.setOnClickListener{

            val date = date.text.toString()
            val intro = intro.text.toString()
            val body = body.text.toString()
            val outro = outro.text.toString()

            val diary = Diary(date = date, intro = intro, body = body, outro = outro)

            if(date.isNotEmpty() && intro.isNotEmpty() && body.isNotEmpty() && outro.isNotEmpty()) {
                diaryHandler.create(diary)
                Toast.makeText(this, "Entry Added to Diary", Toast.LENGTH_SHORT).show()
                clearFields()
            }
            else if(date.isEmpty() || intro.isEmpty() || body.isEmpty() || outro.isEmpty()){
                Toast.makeText(this, "Fill Up All Fields", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun clearFields() {
        date.text.clear()
        intro.text.clear()
        body.text.clear()
        outro.text.clear()
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