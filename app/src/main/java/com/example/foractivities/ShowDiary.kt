package com.example.foractivities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShowDiary: AppCompatActivity() {

    lateinit var date: EditText
    lateinit var intro: EditText
    lateinit var body: EditText
    lateinit var outro: EditText
    lateinit var save: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_diary)
        val handler = DiaryHelper(this)

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

            if(date.isNotEmpty() && intro.isNotEmpty() && body.isNotEmpty() && outro.isNotEmpty()) {
                handler.insertDiaryEntry(date, intro, body, outro)
                Toast.makeText(this, "Entry Added to Diary", Toast.LENGTH_SHORT).show()
            }
            else if(date.isEmpty() || intro.isEmpty() || body.isEmpty() || outro.isEmpty()){
                Toast.makeText(this, "Fill Up All Fields", Toast.LENGTH_SHORT).show()
            }
        }



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