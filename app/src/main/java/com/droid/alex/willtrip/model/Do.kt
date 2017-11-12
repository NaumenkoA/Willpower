package com.droid.alex.willtrip.model

class Do(val name: String, val note: String, val isPositive: Boolean = true, val complexity: Int, val days: HashSet<DayOfWeek>) {
}