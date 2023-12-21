package com.example.tour_guide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ShoppingCartAdapter(context: Context, items: List<ShoppingCartItem>) :
    ArrayAdapter<ShoppingCartItem>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.shopping_cart_item, parent, false)
        }

        val currentItem = getItem(position)

        // Set the data to the views in the layout
        val itemImageView: ImageView = itemView!!.findViewById(R.id.itemImageView)
        val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        val itemPriceTextView: TextView = itemView.findViewById(R.id.itemPriceTextView)

        // Assuming you have a method to get the image resource ID based on the item name
        val imageResourceId = getImageResourceId(currentItem?.itemName)
        itemImageView.setImageResource(imageResourceId)

        itemNameTextView.text = currentItem?.itemName
        itemPriceTextView.text = "Rp. ${currentItem?.itemPrice}"

        return itemView
    }

    private fun getImageResourceId(itemName: String?): Int {
        return when (itemName) {
            "Kawah Putih Ciwidey" -> R.drawable.wisata1
            "Orchid Forest Cikole" -> R.drawable.wisata2
            "Laut bantung" -> R.drawable.wisata3
            "GbLa" -> R.drawable.wisata4
            "Resti Kirana" -> R.drawable.foto1
            "Assyfia Ayunda" -> R.drawable.foto2
            // Add more cases as needed
            else -> R.drawable.iconhome // Default image resource ID
        }
    }
}
