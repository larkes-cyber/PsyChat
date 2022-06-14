package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    lateinit var out:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Write a message to the database
        // Write a message to the database

        val but:Button = findViewById(R.id.send)
        val inp:EditText = findViewById(R.id.input)
        out = findViewById(R.id.output)


        val database = Firebase.database("https://test-19cf9-default-rtdb.firebaseio.com")
        val myRef = database.getReference("message")

        but.setOnClickListener {
            myRef.setValue(inp.text.toString())
        }
        onChangeListener(myRef)

    }
//dfgdfg
    private fun onChangeListener(gRef:DatabaseReference){
        gRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                out.append("\n")
                out.append("Sergey: ${snapshot.value.toString()}")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}