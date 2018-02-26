package com.droid.alex.willtrip.model.period

import com.droid.alex.willtrip.model.DayOfWeek

class PeriodDays(val type:String = Period.TYPE_DAYS,val daysOfWeek: Array<DayOfWeek> = arrayOf()) : Period(type)