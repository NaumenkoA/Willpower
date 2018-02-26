package com.droid.alex.willtrip.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne
import java.util.*

@Entity
class Result (@Id var id: Long = 0,
              val date: Date,
              val isPositive: Boolean?,
              val willPoint: Int) {

    lateinit var doObj: ToOne <Do>
}

