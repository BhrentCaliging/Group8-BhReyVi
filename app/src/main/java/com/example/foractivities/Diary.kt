package com.example.foractivities

class Diary {
    constructor(id: Int, date: String, intro: String, body: String, outro:String){
    }
    constructor(date: String, intro: String, body: String, outro:String) {
    }
    constructor(id: Int) {
        val id = 0
    }
    override fun toString(): String {
        return "Date: $(date), Intro: $(intro)"
    }
}