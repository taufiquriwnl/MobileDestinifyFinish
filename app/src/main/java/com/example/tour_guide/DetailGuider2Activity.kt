package com.example.tour_guide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailGuider2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_guider2)

        val guider2_detail_image: ImageView = findViewById(R.id.guider2_detail_image)
        val guider2_detail_name: TextView = findViewById(R.id.guider2_detail_name)
        val guider2_detail_rating: ImageView = findViewById(R.id.guider2_detail_rating)
        val guider2_detail_price: TextView = findViewById(R.id.guider2_detail_price)
        val buttonPesan: Button = findViewById(R.id.button_pesan)

        guider2_detail_image.setImageResource(R.drawable.foto2)
        guider2_detail_name.text = "Assyfia Ayunda"
        guider2_detail_rating.setImageResource(R.drawable.iconstar)
        guider2_detail_price.text = "Rp. 60.000"

        buttonPesan.setOnClickListener {
            val shoppingCartItem = ShoppingCartItem(
                "Assyfia Ayunda",
                "Travel",
                60000.0
            )
            ShoppingCart.addItem(shoppingCartItem)

            val intent = Intent(this, ShoppingCartActivity::class.java)
            intent.putExtra("ITEM_TYPE", "Travel")
            intent.putExtra("ITEM_NAME", "Assyfia Ayunda")
            intent.putExtra("ITEM_PRICE", 60000.0)
            startActivity(intent)
        }
    }
}
