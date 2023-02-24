package com.example.allhands

import android.content.Intent
import android.net.wifi.hotspot2.pps.HomeSp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.search -> startActivity(Intent(this@MainActivity,SearchActivity::class.java))
                R.id.home -> startActivity(Intent(this@MainActivity,MainActivity::class.java))
                R.id.map -> startActivity(Intent(this@MainActivity,MapsActivity::class.java))
            }
            true
        }


        val onlineButton = findViewById<Button>(R.id.online)
        onlineButton.setOnClickListener {
            val Intent = Intent(this, SearchActivity::class.java)
            startActivity(Intent)

        val inPersonButton = findViewById<Button>(R.id.in_person)
        onlineButton.setOnClickListener {
            val Intent2 = Intent(this, MapsActivity::class.java)
            startActivity(Intent2) }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item))

            return true

        return super.onOptionsItemSelected(item)
    }


}