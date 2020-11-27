package com.example.foractivities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, dbname, null, version) {
    companion object{
        private val dbname = "activityDatabase"
        private val version = 1

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table user(id integer primary key autoincrement,"+
                    "username varchar(100),password varchar(30))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertUserData(username: String, password: String){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("username",username)
        values.put("password", password)

        db.insert("user", null, values)
        db.close()
    }

    fun userPresent(username: String, password: String): Boolean {
        val db= writableDatabase
        val query= "select * from user where username = '$username' and password = '$password'"
        val cursor = db.rawQuery(query,null)
            if(cursor.count <=0){
                cursor.close()
                return false
            }
            cursor.close()
            return true
    }
}