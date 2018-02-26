package com.droid.alex.willtrip.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Will (@Id (assignable = true) var id: Long = 1,
            private var willPower: Int = 0) {

    fun getWillPower (): Int {
        return willPower
    }

    fun increase (value: Int) {
        willPower += value
    }

    fun decrease (value: Int) {
        willPower -= value
        if (willPower <0) willPower == 0
    }
}