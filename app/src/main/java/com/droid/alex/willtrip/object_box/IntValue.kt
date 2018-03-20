package com.droid.alex.willtrip.object_box

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class IntValue (@Id(assignable = true) var id: Long, val value: Int) {
}