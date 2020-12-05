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
import com.example.foractivities.handlers.ScriptHandler
import com.example.foractivities.models.Script
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ScriptActivity : AppCompatActivity() {
    lateinit var scripts: ArrayList<Script>
    lateinit var scriptListView: ListView
    lateinit var scriptHandler: ScriptHandler
    lateinit var script: Script

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_script)

        scriptListView = findViewById(R.id.script_ListView)
        scripts = ArrayList()
        scriptHandler = ScriptHandler()

        registerForContextMenu(scriptListView)
        scriptListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            script = scripts[position]
            var intent = Intent(this,ScriptItemActivity::class.java)
            intent.putExtra("data", script)
            startActivity(intent)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.script_item_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when(item.itemId) {
            R.id.go_to_edit_script -> {
                script = scripts[info.position]
                var intent = Intent(this,ScriptEditActivity::class.java)
                intent.putExtra("data", script)
                startActivity(intent)
                true
            }
            R.id.go_to_delete_script -> {
                if(scriptHandler.delete(scripts[info.position])){
                    Toast.makeText(applicationContext, "Script deleted successfully", Toast.LENGTH_SHORT).show()
                }
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()

        scriptHandler.scriptRef.addValueEventListener(object:
            ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                scripts.clear()
                p0.children.forEach{
                        it -> val channel = it.getValue(Script::class.java)
                    scripts.add(channel!!)
                }

                val adapter = ArrayAdapter<Script>(applicationContext, android.R.layout.simple_list_item_1, scripts)
                scriptListView.adapter = adapter
            }
            override fun onCancelled(p0: DatabaseError) {

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.script_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.go_to_add_script -> {
                startActivity(Intent(this, ScriptAddActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}