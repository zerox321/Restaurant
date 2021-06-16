package com.example.datalayer

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MenuItem(
    val description: String? = "",
    val id: Int? = 0,
    val name: String? = "",
    val price: Double? = 0.0,
    val thumbnail: String? = ""
) : Parcelable {
    fun getFormattedPrice() = "₹ $price"
}