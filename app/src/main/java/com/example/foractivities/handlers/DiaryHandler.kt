package com.example.foractivities.handlers

import com.example.foractivities.models.Diary
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DiaryHandler {
    var database: FirebaseDatabase
    var diaryRef: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance()
        diaryRef = database.getReference("diaries")
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