package com.example.foractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.foractivities.handlers.ScriptHandler
import com.example.foractivities.models.Script

class ScriptEditActivity : AppCompatActivity() {
    lateinit var btn_confirm: Button
    lateinit var et_fade: EditText
    lateinit var et_scene: EditText
    lateinit var et_action: EditText
    lateinit var et_character: EditText
    lateinit var et_parenthetical: EditText
    lateinit var et_line: EditText
    lateinit var et_transition: EditText
    lateinit var scriptHandler: ScriptHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_script_edit)

        var scriptItems: Script = intent.getSerializableExtra("data") as Script

        et_fade = findViewById(R.id.et_fade_edit)
        et_scene = findViewById(R.id.et_sceneHeading_edit)
        et_action = findViewById(R.id.et_action_edit)
        et_character = findViewById(R.id.et_character_edit)
        et_parenthetical = findViewById(R.id.et_Parenthetical_edit)
        et_line = findViewById(R.id.et_line_edit)
        et_transition = findViewById(R.id.et_transition_edit)
        scriptHandler = ScriptHandler()
        btn_confirm = findViewById(R.id.btn_confirm_script_edit)

        et_fade.setText(scriptItems.fade)
        et_scene.setText(scriptItems.scene)
        et_action.setText(scriptItems.action)
        et_character.setText(scriptItems.character)
        et_parenthetical.setText(scriptItems.parenthetical)
        et_line.setText(scriptItems.line)
        et_transition.setText(scriptItems.transition)

        btn_confirm.setOnClickListener {
            val fade = et_fade.text.toString()
            val scene = et_scene.text.toString()
            val action = et_action.text.toString()
            val character = et_character.text.toString()
            val parenthetical = et_parenthetical.text.toString()
            val line = et_line.text.toString()
            val transition = et_transition.text.toString()

            val script = Script(id = scriptItems.id, fade = fade, scene = scene, action = action, character = character, parenthetical = parenthetical, line = line, transition = transition)

            if(et_fade.text.toString().isNotEmpty() && et_scene.text.toString().isNotEmpty() && et_action.text.toString().isNotEmpty() && et_character.text.toString().isNotEmpty()
                && et_parenthetical.text.toString().isNotEmpty() && et_line.text.toString().isNotEmpty() && et_transition.text.toString().isNotEmpty()){
                scriptHandler.update(script)
                Toast.makeText(applicationContext, "Script edited successfully", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, "Please enter the credentials", Toast.LENGTH_SHORT).show()
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