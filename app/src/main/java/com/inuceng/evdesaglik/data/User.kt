package com.inuceng.evdesaglik.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val tc: String,
    val password: String,
    val name: String,
    val dateOfBirth :String,
    val lastName : String
): Parcelable
