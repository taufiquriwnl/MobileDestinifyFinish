package com.example.tour_guide

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

class ShoppingCartActivity : AppCompatActivity() {
    private lateinit var listViewCartItems: ListView
    private lateinit var textViewTotalPrice: TextView
    private lateinit var buttonCheckout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        listViewCartItems = findViewById(R.id.listViewCartItems)
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice)
        buttonCheckout = findViewById(R.id.buttonCheckout)

        FirebaseApp.initializeApp(this)

        val items = ShoppingCart.getItems()

        val adapter = ShoppingCartAdapter(this, items)
        listViewCartItems.adapter = adapter

        val totalPrice = ShoppingCart.getTotalPrice()
        textViewTotalPrice.text = "Total Price: Rp. $totalPrice"

        buttonCheckout.setOnClickListener {

            checkoutAndSaveToFirebase(items, totalPrice)
        }
    }

    private fun checkoutAndSaveToFirebase(items: List<ShoppingCartItem>, totalPrice: Double) {
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("checkout_data")

        val checkoutData = mapOf(
            "items" to items.map { it.itemName },
            "totalPrice" to totalPrice
        )

        reference.push().setValue(checkoutData)
            .addOnSuccessListener {
                showToast("Sukses Memesan")
            }
            .addOnFailureListener {
                showToast("Gagal Memesan")
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
