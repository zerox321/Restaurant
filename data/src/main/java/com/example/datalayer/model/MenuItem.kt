package com.example.datalayer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MenuItem(
    val description: String? = "",
    val id: Int? = 0,
    val rate: Float? = 0f,
    val name: String? = "",
    val color: String? = "#E8AEB1",
    val price: Double? = 0.0,
    val thumbnail: String? = ""
) : Parcelable {
    fun getFormattedPrice() = "₹ $price"
}

