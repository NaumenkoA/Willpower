package com.droid.alex.willtrip.model

import com.droid.alex.willtrip.model.period.Period
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

class Do(var id: Long = 0, val name: String = "", val note: String? = null, val isPositive: Boolean = true, val complexity: Int = 0, val period: Period, val isSpecialDayEnabled: Boolean, val startDate: Date = Calendar.getInstance().time, val expireDate: Date? = null)


