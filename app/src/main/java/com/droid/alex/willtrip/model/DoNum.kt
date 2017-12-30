package com.droid.alex.willtrip.model

import java.util.*

class DoNum(name: String, note: String, isPositive: Boolean, complexity: Int, expireDate: Date?, val numberOfDays: Int) : Do(name, note, isPositive, complexity, expireDate) {
}