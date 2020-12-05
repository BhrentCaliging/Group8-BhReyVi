package com.example.foractivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.foractivities.handlers.ScriptHandler
import com.example.foractivities.models.Script

class ScriptItemActivity : AppCompatActivity() {
    lateinit var et_fade: TextView
    lateinit var et_scene: TextView
    lateinit var et_action: TextView
    lateinit var et_character: TextView
    lateinit var et_parenthetical: TextView
    lateinit var et_line: TextView
    lateinit var et_transition: TextView
    lateinit var scriptHandler: ScriptHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_script_item)

        scriptHandler = ScriptHandler()
        var scriptItems: Script = intent.getSerializableExtra("data") as Script

        et_fade = findViewById(R.id.fade_script)
        et_scene = findViewById(R.id.scene_script)
        et_action = findViewById(R.id.action_script)
        et_character = findViewById(R.id.character_script)
        et_parenthetical = findViewById(R.id.parenthetical_script)
        et_line = findViewById(R.id.line_script)
        et_transition = findViewById(R.id.transition_script)


        et_fade.setText(scriptItems.fade)
        et_scene.setText(scriptItems.scene)
        et_action.setText(scriptItems.action)
        et_character.setText(scriptItems.character)
        et_parenthetical.setText(scriptItems.parenthetical)
        et_line.setText(scriptItems.line)
        et_transition.setText(scriptItems.transition)
    }
}