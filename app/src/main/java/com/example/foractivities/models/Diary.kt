package com.example.foractivities.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
class Diary (var id: String? = "", var date: String? = "", var intro: String? = "", var body: String? = "", var outro: String? = ""):
    Serializable {

    override fun toString(): String {
        return "Entry $date + $intro"
    }
}