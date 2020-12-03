package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.foractivities.handlers.BookHandler
import com.example.foractivities.models.Book
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class BookActivity : AppCompatActivity() {
    lateinit var books: ArrayList<Book>
    lateinit var list: ListView
    lateinit var bookHandler: BookHandler
    lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        list = findViewById(R.id.book_ListView)
        books = ArrayList()
        bookHandler = BookHandler()

        registerForContextMenu(list)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.book_item_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when(item.itemId) {
            R.id.update_book -> {
                book = books[info.position]
                var intent = Intent(this,BookEditActivity::class.java)
                intent.putExtra("data", book)
                startActivity(intent)
                true
            }
            R.id.delete_book -> {
                if(bookHandler.delete(books[info.position])){
                    Toast.makeText(applicationContext, "Book entry deleted successfully", Toast.LENGTH_SHORT).show()
                }
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()

        bookHandler.bookRef.addValueEventListener(object:
            ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                books.clear()
                p0.children.forEach{
                        it -> val book = it.getValue(Book::class.java)
                    books.add(book!!)
                }

                val adapter = ArrayAdapter<Book>(applicationContext, android.R.layout.simple_list_item_1, books)
                list.adapter = adapter
            }
            override fun onCancelled(p0: DatabaseError) {

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.book_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.addBook -> {
                startActivity(Intent(this, BookAddActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}