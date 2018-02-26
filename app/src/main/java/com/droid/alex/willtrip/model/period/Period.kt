package com.droid.alex.willtrip.model.period

abstract class Period (val periodType: String) {

    companion object {
        const val TYPE_DAYS = "type_days"
        const val TYPE_PERIODIC = "type_periodic"
        const val TYPE_TIMES_A_WEEK = "type_times_a_week"
    }

}


