package com.example.foractivities

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DiaryHelper (context: Context): SQLiteOpenHelper(context, dbname, null, version) {
    companion object{
        private val dbname = "Diaries"
        private val version = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table diary(id integer primary key autoincrement,"+
                "date date(),intro varchar(30),body text(500), outro varchar(30)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertDiaryEntry(date: String, intro: String, body: String, outro: String): Boolean{
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("date",date)
        values.put("intro", intro)
        values.put("body", body)
        values.put("outro", outro)
        val res = db.insert("diary", null, values)
        db.close()
        if (res == (0).toLong()) {
            return true
        }
        return false
    }

    fun readDiaryEntry():MutableList<Diary> {
        val db: SQLiteDatabase = readableDatabase
        val query = "select * from diary"
        var cursor = db.rawQuery(query, null)
        val list: MutableList<Diary> = ArrayList()

        var id: Int = 0
        var date: String
        var intro: String
        var body: String
        var outro: String
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                date = cursor.getString(cursor.getColumnIndex("date"))
                intro = cursor.getString(cursor.getColumnIndex("intro"))
                body = cursor.getString(cursor.getColumnIndex("body"))
                outro = cursor.getString(cursor.getColumnIndex("outro"))
                val diary = Diary(id, date, intro, body, outro)
                list.add(diary)
            } while (cursor.moveToNext())
        }
        return list
    }

}