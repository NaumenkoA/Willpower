package com.droid.alex.willtrip.model

enum class DayOfWeek(val shortName: String, val isWeekday: Boolean) {

    MONDAY ("Mon", true),
    TUESDAY ("Tue", true),
    WEDNESDAY ("Wed", true),
    THURSDAY ("Thu", true),
    FRIDAY ("Fri", true),
    SATURDAY ("Sat", false),
    SUNDAY ("Sun", false)
}