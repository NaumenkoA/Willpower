package com.droid.alex.willtrip.model.core

import com.droid.alex.willtrip.model.period.Period
import com.droid.alex.willtrip.object_box.PeriodConverter
import io.objectbox.annotation.*
import io.objectbox.relation.ToMany
import io.objectbox.relation.ToOne
import java.util.*

@Entity
class Do(@Id var id: Long = 0,
         @Index val name: String = "",
         val note: String? = null,
         val isPositive: Boolean = true,
         val complexity: Int = 0,
         @Convert(converter = PeriodConverter::class, dbType = String::class)
         val period: Period? = null,
         val isSpecialDayEnabled: Boolean = false,
         val startDate: Date = Calendar.getInstance().time,
         val expireDate: Date? = null) {

    lateinit var chain: ToOne<Chain>
    @Backlink
    lateinit var results: ToMany<Result>

}
