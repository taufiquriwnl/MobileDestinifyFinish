package com.example.tour_guide

import java.io.Serializable

data class DestinationItem(
    val name: String,
    val rating: Double,
    val price: Double,
    val imageResourceId: Int
) : Serializable
