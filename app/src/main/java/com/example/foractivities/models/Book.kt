package com.example.foractivities.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
class Book(var id: String? = "", var title: String? = "", var chapter: String? = "", var synopsis: String? = ""):Serializable {

    override fun toString(): String {
        return "Entry $title:   $chapter"
    }
}