package com.droid.alex.willtrip.model.will

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

class Will (private var willPower: Int = 0) {

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