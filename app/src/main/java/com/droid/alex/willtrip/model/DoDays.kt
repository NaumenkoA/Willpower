package com.droid.alex.willtrip.model

import java.util.*
import kotlin.collections.ArrayList

class DoDays(name: String, note: String, isPositive: Boolean, complexity: Int, expireDate: Date?, val numberOfDays: ArrayList <Int>) : Do(name, note, isPositive, complexity, expireDate) {

}