package com.example.placement_registrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.placement_registrationsystem.databinding.ActivitySignupactivityBinding
import com.google.firebase.auth.FirebaseAuth

class Signupactivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupactivityBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupactivity)

        var SignUpbutton = findViewById<Button>(R.id.SignUpbutton)
        var emailsign = findViewById<EditText>(R.id.loginEmail2)
        var passsign = findViewById<EditText>(R.id.password2)
        var alreadyuser = findViewById<TextView>(R.id.alreadyuser)
        var confirmpassword = findViewById<EditText>(R.id.confirmpassword)

        firebaseAuth = FirebaseAuth.getInstance()

        SignUpbutton.setOnClickListener {
            val signemail = emailsign.text.toString()
            val spassword = passsign.text.toString()
            val confpass = confirmpassword.text.toString()

            if (signemail.isNotEmpty() && spassword.isNotEmpty() && confpass.isNotEmpty()) {
                if (spassword == confpass) {
                    firebaseAuth.createUserWithEmailAndPassword(signemail, spassword)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                val intent2 = Intent(this, RegistrationForm::class.java)
                                startActivity(intent2)
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                } else {
                    Toast.makeText(this, "Password does not matched", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
            alreadyuser.setOnClickListener {
                val loginIntent = Intent(this, Loginactivity::class.java)
                startActivity(loginIntent)
            }
        }
    }
