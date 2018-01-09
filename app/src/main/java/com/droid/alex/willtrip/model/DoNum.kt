package com.droid.alex.willtrip.model

import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import java.util.*

@SuppressLint("ParcelCreator")
@Parcelize
class DoNum(name: String, note: String, isPositive: Boolean, complexity: Int, expireDate: Date?, val numberOfDays: Int) : Do(name, note, isPositive, complexity, expireDate) {
}