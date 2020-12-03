package com.example.foractivities.handlers

import com.example.foractivities.models.Script
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ScriptHandler {
    var database: FirebaseDatabase
    var scriptRef: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance()
        scriptRef = database.getReference("scripts")
    }

    fun create(script: Script): Boolean{
        val id = scriptRef.push().key
        script.id = id

        scriptRef.child(id!!).setValue(script)
        return true
    }

    fun update(script: Script): Boolean{
        scriptRef.child(script.id!!).setValue(script)
        return true
    }

    fun delete(script: Script): Boolean{
        scriptRef.child(script.id!!).removeValue()
        return true
    }
}
