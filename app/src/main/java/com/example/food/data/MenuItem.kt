package com.example.food.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val id: String,
    val img: String,
    val name: String,
    @SerialName("dsc") val description: String,
    val price: Double,
    val rate: Int,
    val country: String
)