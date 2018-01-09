package com.droid.alex.willtrip.extension_func

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

fun AppCompatActivity.toastShort (text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.toastLong (text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}