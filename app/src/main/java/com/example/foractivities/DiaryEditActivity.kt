package com.example.foractivities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foractivities.handlers.DiaryHandler
import com.example.foractivities.models.Diary

class DiaryEditActivity: AppCompatActivity() {

    lateinit var date: EditText
    lateinit var intro: EditText
    lateinit var body: EditText
    lateinit var outro: EditText
    lateinit var save: TextView
    lateinit var  diaryHandler: DiaryHandler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_edit)

        diaryHandler = DiaryHandler()
        var diaryItems: Diary = intent.getSerializableExtra("data") as Diary

        date = findViewById(R.id.editDate)
        intro = findViewById(R.id.editIntro)
        body = findViewById(R.id.editBody)
        outro = findViewById(R.id.editOutro)

        date.setText(diaryItems.date)
        intro.setText(diaryItems.intro)
        body.setText(diaryItems.body)
        outro.setText(diaryItems.outro)

        save = findViewById(R.id.editSave)
        save.setOnClickListener{

            val date = date.text.toString()
            val intro = intro.text.toString()
            val body = body.text.toString()
            val outro = outro.text.toString()

            val diary = Diary(id = diaryItems.id, date = date, intro = intro, body = body, outro = outro)

            if(date.isNotEmpty() && intro.isNotEmpty() && body.isNotEmpty() && outro.isNotEmpty()) {
                diaryHandler.update(diary)
                Toast.makeText(this, "Diary entry edited successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DiaryActivity::class.java))
            }
            else if(date.isEmpty() || intro.isEmpty() || body.isEmpty() || outro.isEmpty()){
                Toast.makeText(this, "Fill Up All Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.recents ->{
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }



    }
}