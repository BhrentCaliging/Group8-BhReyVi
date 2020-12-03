package com.example.foractivities.handlers

import com.example.foractivities.models.Book
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class BookHandler {

    var database: FirebaseDatabase
    var bookRef: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance()
        bookRef = database.getReference("books")
    }

    fun create(book: Book): Boolean{
        val id = bookRef.push().key
        book.id = id

        bookRef.child(id!!).setValue(book)
        return true
    }

    fun update(book: Book): Boolean{
        bookRef.child(book.id!!).setValue(book)
        return true
    }

    fun delete(book: Book): Boolean{
        bookRef.child(book.id!!).removeValue()
        return true
    }
}