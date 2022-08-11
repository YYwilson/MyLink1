package com.example.mylink1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val database = FirebaseFirestore.getInstance()
    private val users = mutableListOf<Map<String, String>>()
    private var pref: SharedPreferences? = null
    private var serverIP: String = ""
    //private lateinit var auth: FirebaseAuth
    private val fileName = "Preference"
    private val msg = ""

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //pref = getSharedPreferences(fileName, Context.MODE_PRIVATE)
        //serverIP = pref!!.getString("SERVER_IP", "") as String
        //auth = FirebaseAuth.getInstance()

        val database = Firebase.database//.getInstance()
        val myRef = database.reference
        //Log.d(msg, "${myRef.child("User").key("name")}")
        val text1 = findViewById<TextView>(R.id.textView)
        val text2 = findViewById<TextView>(R.id.textView2)



        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                text1.text= p0.child("User").child("name").value as String
                text2.text= p0.child("User").child("password").value as String
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }



}