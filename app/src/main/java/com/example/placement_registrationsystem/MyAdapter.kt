package com.example.placement_registrationsystem

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

 class MyAdapter(private var dataList: List<DataClass>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val imageView: ImageView = itemView.findViewById(R.id.recImage)
         val Firsttextview: TextView = itemView.findViewById(R.id.retName)
         val emailtextView: TextView = itemView.findViewById(R.id.retemail)
         val contacttextvv: TextView = itemView.findViewById(R.id.retContact)

     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val view: View =
             LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
         return ViewHolder(view)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val data = dataList[position]
         holder.Firsttextview.text = data.FirstName
         holder.emailtextView.text = data.registerEmail
         holder.contacttextvv.text = data.ContactNo
         Glide.with(holder.itemView.context).load(data.profileImage).into(holder.imageView)

     }

     override fun getItemCount(): Int {
         return dataList.size
     }
 }
