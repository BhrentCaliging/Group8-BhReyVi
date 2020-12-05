package com.example.foractivities.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
class Script(var id: String? = "", var fade: String? = "", var scene: String? = "", var action: String? = "",
             var character: String? = "", var parenthetical: String? = "", var line: String? = "", var transition: String? = ""): Serializable {
    
    override fun toString(): String {
        return "Entry $scene:   $character"
    }
}


