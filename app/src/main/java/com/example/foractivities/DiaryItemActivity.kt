package com.example.foractivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.foractivities.handlers.DiaryHandler
import com.example.foractivities.models.Diary

class DiaryItemActivity : AppCompatActivity() {

    lateinit var date: TextView
    lateinit var intro: TextView
    lateinit var body: TextView
    lateinit var outro: TextView
    lateinit var  diaryHandler: DiaryHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_item)

        var diaryItems: Diary = intent.getSerializableExtra("data") as Diary
        diaryHandler = DiaryHandler()

        date = findViewById(R.id.date_diary)
        intro = findViewById(R.id.intro_diary)
        body = findViewById(R.id.body_diary)
        outro = findViewById(R.id.signOff_diary)

        date.setText(diaryItems.date)
        intro.setText(diaryItems.intro)
        body.setText(diaryItems.body)
        outro.setText(diaryItems.outro)

    }
}