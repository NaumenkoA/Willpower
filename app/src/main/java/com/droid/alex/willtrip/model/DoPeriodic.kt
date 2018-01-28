package com.droid.alex.willtrip.model

import java.util.*

class DoPeriodic(name: String, note: String, isPositive: Boolean, complexity: Int, startDate: Date, expireDate: Date?, val period: Int) : Do(name, note, isPositive, complexity, startDate, expireDate) {
}