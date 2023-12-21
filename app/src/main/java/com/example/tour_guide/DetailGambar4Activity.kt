package com.example.tour_guide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailGambar4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_gambar4)

        val gambarDetail4: ImageView = findViewById(R.id.gambarDetail4)
        val namaTempatText: TextView = findViewById(R.id.namaTempatText)
        val ratingImage: ImageView = findViewById(R.id.ratingImage)
        val hargaText: TextView = findViewById(R.id.hargaText)
        val buttonPesan: Button = findViewById(R.id.button_pesan_gambar4)

        gambarDetail4.setImageResource(R.drawable.wisata1)
        namaTempatText.text = "GbLa"
        ratingImage.setImageResource(R.drawable.iconstar)
        hargaText.text = "Rp. 30.000"

        buttonPesan.setOnClickListener {
            val shoppingCartItem = ShoppingCartItem(
                "GbLa",
                "Wisata",
                30000.0
            )
            ShoppingCart.addItem(shoppingCartItem)

            val intent = Intent(this, ShoppingCartActivity::class.java)
            intent.putExtra("ITEM_TYPE", "Wisata")
            intent.putExtra("ITEM_NAME", "GbLa")
            intent.putExtra("ITEM_PRICE", 30000.0)
            startActivity(intent)
        }
    }
}
