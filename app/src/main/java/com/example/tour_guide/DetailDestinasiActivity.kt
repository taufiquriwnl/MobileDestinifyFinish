package com.example.tour_guide

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class DetailDestinasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_destinasi)

        findViewById<View>(R.id.openDetailActivity1).setOnClickListener {
            openDetailActivity(DetailGambar1Activity::class.java)
        }
        findViewById<View>(R.id.openDetailActivity2).setOnClickListener {
            openDetailActivity(DetailGambar2Activity::class.java)
        }
        findViewById<View>(R.id.openDetailActivity3).setOnClickListener {
            openDetailActivity(DetailGambar3Activity::class.java)
        }
        findViewById<View>(R.id.openDetailActivity4).setOnClickListener {
            openDetailActivity(DetailGambar4Activity::class.java)
        }
    }

    private fun openDetailActivity(destinationClass: Class<*>) {
        val intent = Intent(this, destinationClass)
        startActivity(intent)
    }
}
