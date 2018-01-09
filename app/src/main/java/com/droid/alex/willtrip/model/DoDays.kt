package com.droid.alex.willtrip.model


import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import java.util.*
import kotlin.collections.ArrayList

@SuppressLint("ParcelCreator")
@Parcelize
class DoDays(name: String, note: String, isPositive: Boolean, complexity: Int, expireDate: Date?, val numberOfDays: ArrayList <Int>) : Do(name, note, isPositive, complexity, expireDate)
