// Artwork.kt
package com.example.artspace

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artwork(
    val title: String,
    val artist: String,
    val description: String,
    val imageResId: Int // Resource ID for the artwork image
) : Parcelable
