package com.droid.alex.willtrip.model.story

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Obstacle (val id: Int, val type: Int, val value: Int) {
    companion object {
        const val WP = "wp"
        const val COMP = "comp"
        const val NUM = "num"
        const val CHAIN = "chain"
    }
}