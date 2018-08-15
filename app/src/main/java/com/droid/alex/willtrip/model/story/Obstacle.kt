package com.droid.alex.willtrip.model.story

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index
import io.objectbox.annotation.Transient

@Entity
class Obstacle (@Id var id: Long = 0, @Index val link: Int, val textId: Int, var type: String, val addValue: Int = 0, val minValue: Int = 0, var value: Int? = null) {

    companion object {
        const val WP = "wp"
        const val COMP = "comp"
        const val CHAIN = "chain"
        const val COUNT = "count"
        const val BONUS = "bonus"
        const val BONUS_GRANTED = "bonus_granted"
    }
}