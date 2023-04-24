package com.example.placement_registrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class drives : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drives)
        var registerbtn= findViewById<Button>(R.id.RegisterBtn)
        var jobprbtn = findViewById<Button>(R.id.jobprofilebtn)
        val devjd = findViewById<Button>(R.id.jobprofilebtn4)
        val devrevregbtn = findViewById<Button>(R.id.RegisterBtn4)
        val unjd = findViewById<Button>(R.id.jobprofilebtn2)
        val unregbtn = findViewById<Button>(R.id.RegisterBtn2)
        val nowjd = findViewById<Button>(R.id.jobprofilebtn3)
        val nowRegbtn = findViewById<Button>(R.id.RegisterBtn3)

        registerbtn.setOnClickListener {
                val ad = AlertDialog.Builder(this)
                ad.setTitle("Register")
                ad.setMessage("Are you sure?")
                ad.setCancelable(true)

                ad.setPositiveButton("Yes") { Dialog, which ->
                    Toast.makeText(this,"Successfully registered",Toast.LENGTH_LONG).show()
                    registerbtn.text = "Deregister"
                    registerbtn.setBackgroundColor(resources.getColor(R.color.teal_200))

                }
                ad.setNegativeButton("No") {x,y ->
                    Toast.makeText(this,"Registration Cancelled",Toast.LENGTH_LONG).show()

                }
                ad.setNeutralButton("Cancel",null)
                ad.create().show()
        }
        jobprbtn.setOnClickListener {
            val intent = Intent(this, job_profile::class.java)
            startActivity(intent)
        }

        devrevregbtn.setOnClickListener {
            val ad = AlertDialog.Builder(this)
            ad.setTitle("Register")
            ad.setMessage("Are you sure?")
            ad.setCancelable(true)

            ad.setPositiveButton("Yes") { Dialog, which ->
                Toast.makeText(this,"Successfully registered",Toast.LENGTH_LONG).show()
                devrevregbtn.text = "Deregister"
                devrevregbtn.setBackgroundColor(resources.getColor(R.color.teal_200))
            }
            ad.setNegativeButton("No") {x,y ->
                Toast.makeText(this,"Registration Cancelled",Toast.LENGTH_LONG).show()
            }
            ad.setNeutralButton("Cancel",null)
            ad.create().show()
        }
        devjd.setOnClickListener {
            val intent = Intent(this, devrev::class.java)
            startActivity(intent)
        }

        unregbtn.setOnClickListener {
            val ad = AlertDialog.Builder(this)
            ad.setTitle("Register")
            ad.setMessage("Are you sure?")
            ad.setCancelable(true)

            ad.setPositiveButton("Yes") { Dialog, which ->
                Toast.makeText(this,"Successfully registered",Toast.LENGTH_LONG).show()
                unregbtn.text = "Deregister"
                unregbtn.setBackgroundColor(resources.getColor(R.color.teal_200))
            }
            ad.setNegativeButton("No") {x,y ->
                Toast.makeText(this,"Registration Cancelled",Toast.LENGTH_LONG).show()
            }
            ad.setNeutralButton("Cancel",null)
            ad.create().show()
        }
        unjd.setOnClickListener {
            val intent = Intent(this, unstop::class.java)
            startActivity(intent)
        }

        nowRegbtn.setOnClickListener {
            val ad = AlertDialog.Builder(this)
            ad.setTitle("Register")
            ad.setMessage("Are you sure?")
            ad.setCancelable(true)

            ad.setPositiveButton("Yes") { Dialog, which ->
                Toast.makeText(this,"Successfully registered",Toast.LENGTH_LONG).show()
                nowRegbtn.text = "Deregister"
                nowRegbtn.setBackgroundColor(resources.getColor(R.color.teal_200))
            }
            ad.setNegativeButton("No") {x,y ->
                Toast.makeText(this,"Registration Cancelled",Toast.LENGTH_LONG).show()
            }
            ad.setNeutralButton("Cancel",null)
            ad.create().show()
        }
        nowjd.setOnClickListener {
            val intent = Intent(this, unstop::class.java)
            startActivity(intent)
        }

    }
}