package com.droid.alex.willtrip.extension_func

import android.content.Context
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.DatePicker
import java.util.*


fun Button.setColor (context: Context, color: Int) {
    this.setBackgroundColor(ContextCompat.getColor(context, color))
}

fun DatePicker.getDate (): Date {
    val day = this.dayOfMonth
    val month = this.month
    val year = this.year

    val calendar = Calendar.getInstance()
    calendar.set(year, month, day)

    return calendar.time
}

