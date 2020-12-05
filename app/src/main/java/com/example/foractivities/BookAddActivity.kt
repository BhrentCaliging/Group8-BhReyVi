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


class BookAddActivity : AppCompatActivity() {
    lateinit var et_title: EditText
    lateinit var et_chapter: EditText
    lateinit var et_synopsis: EditText
    lateinit var save: Button
    lateinit var bookHandler: BookHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_add)

        et_title = findViewById(R.id.et_book_title)
        et_chapter = findViewById(R.id.et_book_chapter)
        et_synopsis = findViewById(R.id.et_book_synopsis)
        save = findViewById(R.id.btn_save_book)
        bookHandler = BookHandler()

        save.setOnClickListener {

            val title = et_title.text.toString()
            val chapter = et_chapter.text.toString()
            val synopsis = et_synopsis.text.toString()

            val book = Book(title = title, chapter = chapter, synopsis = synopsis)
            if(title.isNotEmpty() && chapter.isNotEmpty() && synopsis.isNotEmpty()){
                bookHandler.create(book)
                Toast.makeText(this, "Entry Added to Book", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, BookActivity::class.java))
                clearFields()
            }
            else
                Toast.makeText(this, "Fill Up All Fields", Toast.LENGTH_SHORT).show()
        }
    }

    fun clearFields() {
        et_title.text.clear()
        et_chapter.text.clear()
        et_synopsis.text.clear()
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