package com.dimasdwipriyono_19102187.siuwa

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyData(
    var name: String,
    var description: String,
    var photo: String,
    var jam_buka: String
    ) : Parcelable