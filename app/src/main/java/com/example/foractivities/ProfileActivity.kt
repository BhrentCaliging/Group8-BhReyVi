package com.example.foractivities

import androidx.appcompat.app.AppCompatActivity
/*
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
*/

class ProfileActivity : AppCompatActivity() {
    /*
    private var occupationTxtView: TextView? = null
    private var nameTxtView: TextView? = null
    private var workTxtView: TextView? = null
    private var emailTxtView: TextView? = null
    private var phoneTxtView: TextView? = null
    private var videoTxtView: TextView? = null
    private var facebookTxtView: TextView? = null
    private var twitterTxtView: TextView? = null
    private var userImageView: ImageView? = null
    private var emailImageView: ImageView? = null
    private var phoneImageView: ImageView? = null
    private var videoImageView: ImageView? = null
    private var facebookImageView: ImageView? = null
    private var twitterImageView: ImageView? = null
    private val TAG = this.javaClass.name.toUpperCase()
    private val database: FirebaseDatabase? = null
    private val mDatabase: DatabaseReference? = null
    private val userMap: Map<String, String>? = null
    private var email: String? = null
    private val userid: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        //receive data from login screen
        val intent = intent
        email = intent.getStringExtra("email")
        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().getReference()
        val userRef: DatabaseReference = rootRef.child(ProfileActivity.Companion.USERS)
        Log.v("USERID", userRef.getKey())
        occupationTxtView = findViewById(R.id.occupation_textview)
        nameTxtView = findViewById(R.id.name_textview)
        workTxtView = findViewById(R.id.workplace_textview)
        emailTxtView = findViewById(R.id.email_textview)
        phoneTxtView = findViewById(R.id.phone_textview)
        videoTxtView = findViewById(R.id.video_textview)
        facebookTxtView = findViewById(R.id.facebook_textview)
        twitterTxtView = findViewById(R.id.twitter_textview)
        userImageView = findViewById(R.id.user_imageview)
        emailImageView = findViewById(R.id.email_imageview)
        phoneImageView = findViewById(R.id.phone_imageview)
        videoImageView = findViewById(R.id.phone_imageview)
        facebookImageView = findViewById(R.id.facebook_imageview)
        twitterImageView = findViewById(R.id.twitter_imageview)

        // Read from the database
        userRef.addValueEventListener(object : ValueEventListener() {
            var fname: String? = null
            var mail: String? = null
            var profession: String? = null
            var workplace: String? = null
            var phone: String? = null
            fun onDataChange(dataSnapshot: DataSnapshot) {
                for (keyId in dataSnapshot.getChildren()) {
                    if (keyId.child("email").getValue().equals(email)) {
                        fname = keyId.child("fullName").getValue(String::class.java)
                        profession = keyId.child("profession").getValue(String::class.java)
                        workplace = keyId.child("workplace").getValue(String::class.java)
                        phone = keyId.child("phone").getValue(String::class.java)
                        break
                    }
                }
                nameTxtView.setText(fname)
                emailTxtView.setText(email)
                occupationTxtView.setText(profession)
                workTxtView.setText(workplace)
                phoneTxtView.setText(phone)
                videoTxtView.setText(phone)
            }

            fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        *
     */
    }

    /*
    companion object {
        private const val USERS = "users"
    }
     */
