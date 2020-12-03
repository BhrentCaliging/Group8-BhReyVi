package com.example.foractivities.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
class Script(var id: String? = "", var fade: String? = "", var scene: String? = "", var action: String? = "",
             var character: String? = "", var parenthetical: String? = "", var line: String? = "", var transition: String? = ""): Serializable {
    
    override fun toString(): String {
        return "Fade is  $fade \n\n"+
                "Scene is $scene \n\n"+
                "Action is $action \n\n"+
                "Character is $character \n\n"+
                "Parenthetical is $parenthetical \n\n"+
                "Line is $line \n\n"+
                "Transition is $transition \n\n"
    }
}


