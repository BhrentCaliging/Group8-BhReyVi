package com.example.foractivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.foractivities.handlers.BookHandler
import com.example.foractivities.models.Book

class BookItemActivity : AppCompatActivity() {

    lateinit var et_title: TextView
    lateinit var et_chapter: TextView
    lateinit var et_synopsis: TextView
    lateinit var bookHandler: BookHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_item)

        bookHandler = BookHandler()
        var bookItems: Book = intent.getSerializableExtra("data") as Book

        et_title = findViewById(R.id.title_book)
        et_chapter = findViewById(R.id.chapter_book)
        et_synopsis = findViewById(R.id.synopsis_book)

        et_title.setText(bookItems.title)
        et_chapter.setText(bookItems.chapter)
        et_synopsis.setText(bookItems.synopsis)
    }
}