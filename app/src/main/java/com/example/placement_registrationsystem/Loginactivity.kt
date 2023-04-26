package com.example.placement_registrationsystem

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.placement_registrationsystem.databinding.ActivityLoginactivityBinding
import com.google.firebase.auth.FirebaseAuth

class Loginactivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityLoginactivityBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_loginactivity)
        var loginButton = findViewById<Button>(R.id.Loginbutton)
        var email = findViewById<EditText>(R.id.loginEmail)
        var password = findViewById<EditText>(R.id.password)
        var newuser = findViewById<TextView>(R.id.newuser)
        var forgotpassword = findViewById<TextView>(R.id.forgotpassword)

        firebaseAuth = FirebaseAuth.getInstance()


        loginButton.setOnClickListener {


            val logemail = email.text.toString()
            val cpassword = password.text.toString()

                if(logemail.isNotEmpty() && cpassword.isNotEmpty()) {
                    firebaseAuth.signInWithEmailAndPassword(logemail,cpassword).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, DASHBOARD_DRAWER::class.java)
                            startActivity(intent)
                        }
                        else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                }
                else {
                    Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                }
        }


        forgotpassword.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.activity_forgotpassword_dialog,null)
            val usremail = findViewById<EditText>(R.id.forgotemailedittext)
            builder.setView(view)
            val dialog = builder.create()
            view.findViewById<Button>(R.id.btnReset).setOnClickListener {
                compareEmail(usremail)
                dialog.dismiss()
            }
            view.findViewById<Button>(R.id.btnCancel).setOnClickListener {
                dialog.dismiss()
            }
            if(dialog.window != null) {
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
        }
        newuser.setOnClickListener {
            val signupIntent = Intent(this, Signupactivity::class.java)
            startActivity(signupIntent)

        }
    }

    private fun compareEmail(email: EditText){
        if (email.text.toString().isEmpty()){
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            return
        }
        firebaseAuth.sendPasswordResetEmail(email.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Check your email", Toast.LENGTH_SHORT).show()
                }
            }
    }
}


