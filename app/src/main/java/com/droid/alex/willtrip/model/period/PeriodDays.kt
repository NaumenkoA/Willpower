package com.droid.alex.willtrip.model.period

class PeriodDays(val type:String = Period.TYPE_DAYS,val daysOfWeek: Array<DayOfWeek> = arrayOf()) : Period(type) {
    fun containsDay (dayIndex: Int):Boolean {
        for (day in daysOfWeek) {
            if (day.id == dayIndex) return true
        }
        return false
    }
}