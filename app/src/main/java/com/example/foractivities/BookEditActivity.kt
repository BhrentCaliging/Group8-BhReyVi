package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.foractivities.handlers.BookHandler
import com.example.foractivities.models.Book


class BookEditActivity : AppCompatActivity() {
    lateinit var et_title: EditText
    lateinit var et_chapter: EditText
    lateinit var et_synopsis: EditText
    lateinit var save: Button
    lateinit var bookHandler: BookHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_edit)

        bookHandler = BookHandler()
        var bookItems: Book = intent.getSerializableExtra("data") as Book

        et_title = findViewById(R.id.et_book_title_edit)
        et_chapter = findViewById(R.id.et_book_chapter_edit)
        et_synopsis = findViewById(R.id.et_book_synopsis_edit)
        save = findViewById(R.id.btn_save_book_edit)

        et_title.setText(bookItems.title)
        et_chapter.setText(bookItems.chapter)
        et_synopsis.setText(bookItems.synopsis)

        save.setOnClickListener {

            val title = et_title.text.toString()
            val chapter = et_chapter.text.toString()
            val synopsis = et_synopsis.text.toString()

            val book = Book(id = bookItems.id, title = title, chapter = chapter, synopsis = synopsis)
            if(title.isNotEmpty() && chapter.isNotEmpty() && synopsis.isNotEmpty()){
                bookHandler.update(book)
                Toast.makeText(this, "Book entry edited successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, BookActivity::class.java))
            }
            else
                Toast.makeText(this, "Fill Up All Fields", Toast.LENGTH_SHORT).show()
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