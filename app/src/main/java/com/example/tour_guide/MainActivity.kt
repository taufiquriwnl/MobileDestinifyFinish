package com.example.tour_guide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shopingview = findViewById<ImageView>(R.id.shopping_cart_icon)
        shopingview.setOnClickListener {
            val intent = Intent(this, ShoppingCartActivity::class.java)
            startActivity(intent)
        }


        val buttonGuider1 = findViewById<Button>(R.id.buttonguider1)
        buttonGuider1.setOnClickListener {
            val intent = Intent(this, DetailGuider1Activity::class.java)
            startActivity(intent)
        }

        val buttonGuider2 = findViewById<Button>(R.id.buttonguider2)
        buttonGuider2.setOnClickListener {
            val intent = Intent(this, DetailGuider2Activity::class.java)
            startActivity(intent)
        }

        val destinasiImageView = findViewById<ImageView>(R.id.destinasi)
        destinasiImageView.setOnClickListener {
            val intent = Intent(this, DetailDestinasiActivity::class.java)
            startActivity(intent)
        }
    }
}
