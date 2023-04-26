package com.example.placement_registrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class announcement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announcement)

        val textView1 = findViewById<TextView>(R.id.textView1)
        textView1.setOnClickListener {

            val intent = Intent(this, newactivity::class.java)
            startActivity(intent)
            // Open new layout here
        }

        val textView2 = findViewById<TextView>(R.id.textView2)
        textView2.setOnClickListener {
            // Open new layout here

            val intent = Intent(this, newactivity::class.java)
            startActivity(intent)
        }
    }
}