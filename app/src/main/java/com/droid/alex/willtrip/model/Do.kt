package com.droid.alex.willtrip.model


import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@SuppressLint("ParcelCreator")
@Parcelize
open class Do(val name: String, val note: String?, val isPositive: Boolean = true, val complexity: Int, val expireDate: Date?) : Parcelable