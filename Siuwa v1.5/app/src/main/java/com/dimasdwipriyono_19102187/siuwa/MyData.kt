package com.dimasdwipriyono_19102187.siuwa

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyData(
    var name: String,
    var description: String,
    var photo: String,
    var harga: String,
    var alamat: String,
    var jam_buka: String,
    val lat: Double,
    val lang: Double
    ) : Parcelable