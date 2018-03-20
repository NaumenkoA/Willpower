package com.droid.alex.willtrip.model.story

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Transient

@Entity
class Obstacle (@Id(assignable = true) var id: Long, val textId: Int, val type: String, val value: Int) {

    companion object {
        const val WP = "wp"
        const val COMP = "comp"
        const val COUNT = "count"
        const val CHAIN = "chain"
    }
}