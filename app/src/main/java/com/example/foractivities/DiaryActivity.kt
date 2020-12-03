package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class DiaryActivity : AppCompatActivity() {

    lateinit var list: ListView
    lateinit var helper: DiaryHelper
    lateinit var entryList: MutableList<Diary>
    lateinit var adapter: ArrayAdapter<Diary>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        helper = DiaryHelper(this)
        entryList = helper.readDiaryEntry()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, entryList)


        list = findViewById(R.id.listView)
        list.adapter = adapter

        list.setOnClickListener {
            //adapter.getItemId()

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