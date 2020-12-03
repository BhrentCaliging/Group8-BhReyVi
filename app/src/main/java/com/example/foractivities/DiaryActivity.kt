package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.foractivities.handlers.DiaryHandler
import com.example.foractivities.handlers.ScriptHandler
import com.example.foractivities.models.Diary
import com.example.foractivities.models.Script
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class DiaryActivity : AppCompatActivity() {

    lateinit var diaries: ArrayList<Diary>
    lateinit var list: ListView
    lateinit var diaryHandler: DiaryHandler
    lateinit var diary: Diary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        list = findViewById(R.id.listView_diary)
        diaries = ArrayList()
        diaryHandler = DiaryHandler()

        registerForContextMenu(list)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.diary_item_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when(item.itemId) {
            R.id.update_diary -> {
                diary = diaries[info.position]
                var intent = Intent(this,DiaryEditActivity::class.java)
                intent.putExtra("data", diary)
                startActivity(intent)
                true
            }
            R.id.delete_diary -> {
                if(diaryHandler.delete(diaries[info.position])){
                    Toast.makeText(applicationContext, "Diary entry deleted successfully", Toast.LENGTH_SHORT).show()
                }
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()

        diaryHandler.diaryRef.addValueEventListener(object:
            ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                diaries.clear()
                p0.children.forEach{
                        it -> val diary = it.getValue(Diary::class.java)
                    diaries.add(diary!!)
                }

                val adapter = ArrayAdapter<Diary>(applicationContext, android.R.layout.simple_list_item_1, diaries)
                list.adapter = adapter
            }
            override fun onCancelled(p0: DatabaseError) {

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.diary_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.addDiary -> {
                startActivity(Intent(this, DiaryAddActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}