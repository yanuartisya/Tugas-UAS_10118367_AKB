package com.mario.gonzaga_10118390.UAS_10118367_AKB

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// 12-08-2021 Mario Gonzaga Muharjani - IF9

@Parcelize
data class MapsModel (
    var gambar: String = "",
    var keterangan: String = "",
    var latitude: Double = 0.0,
    var longitude: Double = 0.0,
    var nama: String = ""
) : Parcelable