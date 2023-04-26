package com.example.placement_registrationsystem

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask

class uploadcv : AppCompatActivity() {
    val PDF : Int = 0

    lateinit var uri : Uri
    lateinit var mStorage : StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uploadcv)
        val pdfBtn = findViewById<View>(R.id.pdfBtn) as Button

        mStorage = FirebaseStorage.getInstance().getReference("Uploads")

        pdfBtn.setOnClickListener(View.OnClickListener {
                view: View? -> val intent = Intent()
            intent.setType ("application/pdf")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select PDF"), PDF)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //val uriTxt = findViewById<View>(R.id.uriTxt) as TextView
        if (resultCode == RESULT_OK) {
            if (requestCode == PDF) {
                uri = data!!.data!!
                //uriTxt.text = uri.toString()
                upload ()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun upload() {
        var mReference = uri.lastPathSegment?.let { mStorage.child(it) }
        try {
            if (mReference != null) {
                mReference.putFile(uri).addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? -> val downloadURL = taskSnapshot?.getStorage()
                    ?.getDownloadUrl().toString()


                    //val dwnTxt = findViewById<View>(R.id.dwnTxt) as TextView
                    //dwnTxt.text = downloadURL
                    Toast.makeText(this, "Successfully Uploaded :)", Toast.LENGTH_LONG).show()
                }
            }
        }catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }

    }
}