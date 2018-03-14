package com.droid.alex.willtrip.model.core

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne
import java.util.*

@Entity
class Result (@Id var id: Long = 0,
              val date: Date = Calendar.getInstance().time,
              val isPositive: Boolean? = null,
              val willPoint: Int = 0,
              val note: String = "") {

    lateinit var doObj: ToOne <Do>
}

