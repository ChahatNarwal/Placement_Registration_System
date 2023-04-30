package com.example.placement_registrationsystem

import android.graphics.BitmapFactory
import android.media.Image
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class Profile : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    val storage = FirebaseStorage.getInstance()
//    private lateinit var firebaseAuth: FirebaseAuth
    var imageURL: String? = null
    var uri: Uri? = null
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        //val currentDate = DateFormat.getDateTimeInstance().toString()
        val profileImage = findViewById<ImageView>(R.id.profiledisplay)
//        val formatter = SimpleDateFormat("yyyy-MM-dd")
//        val date = Date()
//        val current = formatter.format(date)
//        firebaseAuth = FirebaseAuth.getInstance()
        val calendar = Calendar.getInstance()
        val current = (calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE)).toString()

        val firstNamerectt = findViewById<TextView>(R.id.Displayname)
        val emailrectt= findViewById<TextView>(R.id.displayemail)
        val rettcontactNo = findViewById<TextView>(R.id.displayno)
        val rettdegree = findViewById<TextView>(R.id.displaydegree)
        val rettspecail = findViewById<TextView>(R.id.specializationdisplay)
        val rettaddress = findViewById<TextView>(R.id.currentaddressdisplay)
        val rettCgpa = findViewById<TextView>(R.id.CurrentcgpaDisplay)

//        val intent = intent
//        var userId = intent.getStringExtra("key")
//        val database = FirebaseDatabase.getInstance().reference
        FirebaseDatabase.getInstance().getReference("DATA LIST").child(Firebase.auth.currentUser!!.uid).get().addOnSuccessListener {

            if (it.exists()){

                val firstname = it.child("firstName").value
                val secemail = it.child("registerEmail").value
                val seccontact = it.child("contactNo").value
                val secdegree = it.child("degree").value
                val secspecail = it.child("specialization").value
                val secaddress = it.child("address").value
                val secCgpa = it.child("currentCgpa").value
                Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                firstNamerectt.text = firstname.toString()
                emailrectt.text = secemail.toString()
                rettcontactNo.text = seccontact.toString()
                rettdegree.text = secdegree.toString()
                rettspecail.text = secspecail.toString()
                rettaddress.text = secaddress.toString()
                rettCgpa.text = secCgpa.toString()

            }else{

                Toast.makeText(this,"Updated",Toast.LENGTH_SHORT).show()


            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


        }

//        val storageRef = storage.reference
//        val imageRef = storageRef.child("Task Images").child(uri!!.lastPathSegment!!)
//        val imgref = FirebaseStorage.getInstance().reference.child("Task Images").child(uri!!.lastPathSegment!!)
//        imgref.downloadUrl.addOnSuccessListener { imuri ->
//            Glide.with(this)
//                .load(imuri)
//                .into(profileImage)
//        }.addOnFailureListener {
//            Toast.makeText(this,"Can't retreive image",Toast.LENGTH_LONG).show()
//
//        }

//        val localFile = File.createTempFile("image", "jpg")
//        imgref.getFile(localFile).addOnSuccessListener {
//                taskSnapshot ->
//            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
//            profileImage.setImageBitmap(bitmap)
//
//
//        }.addOnFailureListener {
//            Toast.makeText(this,"Can't retreive image",Toast.LENGTH_LONG).show()
//        }

    }
}