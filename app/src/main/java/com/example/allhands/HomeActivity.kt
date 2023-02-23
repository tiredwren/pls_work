package com.example.allhands

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val onlineButton = findViewById<Button>(R.id.online)
        onlineButton.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)

        val inPersonButton = findViewById<Button>(R.id.in_person)
        onlineButton.setOnClickListener {
            val Intent2 = Intent(this, MapsActivity::class.java)
            startActivity(Intent2) }

        }
    }

}