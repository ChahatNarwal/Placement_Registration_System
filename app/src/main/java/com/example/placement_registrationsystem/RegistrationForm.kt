package com.example.placement_registrationsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.util.*

@Suppress("DEPRECATION")
class RegistrationForm : AppCompatActivity() {
    lateinit var ImageUri: Uri
    var imageURL: String? = null
    var uri: Uri? = null
    lateinit var lastName : EditText
    lateinit var registeremail : EditText
    lateinit var Contactno : EditText
    lateinit var degree : EditText
    lateinit var specialization : EditText
    lateinit var currentcgpa : EditText
    lateinit var address : EditText
    lateinit var selecttImage: ImageView
    lateinit var uploadpp : TextView
    lateinit var uploadbtn: Button
    lateinit var firstName: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    lateinit var Continue: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)
        selecttImage = findViewById(R.id.profilepic)
        uploadpp = findViewById(R.id.uploadpp)
        Continue = findViewById(R.id.continuebutton)

        val activityResultLauncher = registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                uri = data!!.data
                selecttImage.setImageURI(uri)
            } else {
                Toast.makeText(this@RegistrationForm, "No Image Selected", Toast.LENGTH_SHORT).show()
            }
        }
        selecttImage.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }
        Continue.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val storageReference = FirebaseStorage.getInstance().reference.child("Task Images")
            .child(uri!!.lastPathSegment!!)
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setView(R.layout.activity_progress_layout)
        val dialog = builder.create()
        dialog.show()
        storageReference.putFile(uri!!).addOnSuccessListener { taskSnapshot ->
            val uriTask = taskSnapshot.storage.downloadUrl
            while (!uriTask.isComplete);
            val urlImage = uriTask.result
            imageURL = urlImage.toString()
            uploadData()
        }.addOnFailureListener {
            Toast.makeText(
                this@RegistrationForm,"can't upload", Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadData() {
        firstName = findViewById(R.id.FirstName)
        lastName = findViewById(R.id.LastNAME)
        registeremail = findViewById(R.id.enterEmail)
        Contactno = findViewById(R.id.ContactNo)
        degree = findViewById(R.id.Degree)
        specialization = findViewById(R.id.specialization)
        currentcgpa = findViewById(R.id.Currentcgpa)
        address = findViewById(R.id.Address)

        val firstName1 = firstName.text.toString()
        val lastName1  = lastName.text.toString()
        val registeremail1 = registeremail.text.toString()
        val degree1 = degree.text.toString()
        val Contactno1 = Contactno.text.toString()
        val specialization1 = specialization.text.toString()
        val currentcgpa1 = currentcgpa.text.toString()
        val address1 = address.text.toString()

        auth = FirebaseAuth.getInstance()
        firebaseAuth = FirebaseAuth.getInstance()

        val dataClass = DataClass(firstName1,lastName1,registeremail1,Contactno1,degree1, specialization1,currentcgpa1,address1,imageURL)
        //val currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().time)
//        val formatter = SimpleDateFormat("yyyy-MM-dd")
//        val date = Date()
//        val current = formatter.format(date)
        //val currentDate = DateFormat.getDateTimeInstance().toString()

        val calendar = Calendar.getInstance()
        val current = (calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE)).toString()
//        val user = FirebaseAuth.getInstance().currentUser
//        val database = FirebaseDatabase.getInstance().reference
//        val userId = database.push().key
        FirebaseDatabase.getInstance().getReference("DATA LIST").child(Firebase.auth.currentUser!!.uid).setValue(dataClass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@RegistrationForm, "Saved", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@RegistrationForm,DASHBOARD_DRAWER::class.java)
                    startActivity(intent)

                }
            }.addOnFailureListener { e ->
                Toast.makeText(
                    this@RegistrationForm, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
    }
    }

