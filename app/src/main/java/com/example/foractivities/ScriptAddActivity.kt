package com.example.foractivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.foractivities.handlers.ScriptHandler
import com.example.foractivities.models.Script

class ScriptAddActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_script_add)

        et_fade = findViewById(R.id.et_fade)
        et_scene = findViewById(R.id.et_sceneHeading)
        et_action = findViewById(R.id.et_action)
        et_character = findViewById(R.id.et_character)
        et_parenthetical = findViewById(R.id.et_parenthetical)
        et_line = findViewById(R.id.et_line)
        et_transition = findViewById(R.id.et_transition)
        scriptHandler = ScriptHandler()
        btn_confirm = findViewById(R.id.btn_confirm_script)

        btn_confirm.setOnClickListener {
            val fade = et_fade.text.toString()
            val scene = et_scene.text.toString()
            val action = et_action.text.toString()
            val character = et_character.text.toString()
            val parenthetical = et_parenthetical.text.toString()
            val line = et_line.text.toString()
            val transition = et_transition.text.toString()

            val script = Script(fade = fade, scene = scene, action = action, character = character, parenthetical = parenthetical, line = line, transition = transition)

            if(et_fade.text.toString().isNotEmpty() && et_scene.text.toString().isNotEmpty() && et_action.text.toString().isNotEmpty() && et_character.text.toString().isNotEmpty()
                && et_parenthetical.text.toString().isNotEmpty() && et_line.text.toString().isNotEmpty() && et_transition.text.toString().isNotEmpty()){
                scriptHandler.create(script)
                Toast.makeText(applicationContext, "Script added successfully", Toast.LENGTH_SHORT).show()
                clearFields()
            }
            else {
                Toast.makeText(applicationContext, "Please enter the credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun clearFields(){
        et_fade.text.clear()
        et_scene.text.clear()
        et_action.text.clear()
        et_character.text.clear()
        et_parenthetical.text.clear()
        et_line.text.clear()
        et_transition.text.clear()
    }
}