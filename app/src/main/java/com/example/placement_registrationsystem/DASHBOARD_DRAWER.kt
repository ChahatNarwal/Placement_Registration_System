package com.example.placement_registrationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DASHBOARD_DRAWER : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_drawer)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerlayout)
        val navView : NavigationView = findViewById(R.id.navigationdrawer)
        val cardview2 : CardView = findViewById(R.id.cardView2)
        val cardview3 : CardView= findViewById(R.id.cardView3)

        cardview2.setOnClickListener {
            val intent = Intent(this,Profile::class.java)
            startActivity(intent)
        }

        cardview3.setOnClickListener {
            val intent = Intent(this,drives::class.java)
            startActivity(intent)
        }

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.profile -> {
                    val intent = Intent(this, Profile::class.java)
                    startActivity(intent)
                    true
                }
                R.id.drivemenu -> {
                    val intent = Intent(this, drives::class.java)
                    startActivity(intent)
                    true
                }
                R.id.home -> {
                    val intent = Intent(this, DASHBOARD_DRAWER::class.java)
                    startActivity(intent)
                    true
                }
                else -> {
                    false
                }
            }
        }

    }
}