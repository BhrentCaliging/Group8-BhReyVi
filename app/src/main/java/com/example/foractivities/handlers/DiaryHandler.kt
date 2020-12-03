package com.example.foractivities.handlers

import com.example.foractivities.models.Diary
import com.example.foractivities.models.Script

class DiaryHandler {
    var database: FirebaseDatabase
    var diaryRef: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance()
        diaryRef = database.getReference("scripts")
    }

    fun create(diary: Diary): Boolean{
        val id = diaryRef.push().key
        diary.id = id

        diaryRef.child(id!!).setValue(diary)
        return true
    }

    fun update(diary: Diary): Boolean{
        diaryRef.child(diary.id!!).setValue(diary)
        return true
    }

    fun delete(diary: Diary): Boolean{
        diaryRef.child(diary.id!!).removeValue()
        return true
    }
}