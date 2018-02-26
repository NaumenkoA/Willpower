package com.droid.alex.willtrip.model.period

import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.model.Will

object WillPower {
    private val willBox = App.instance.getBoxStore().boxFor(Will::class.java)
    private val will = willBox.get(0)

    fun power (): Int {
        return will.getWillPower()
    }

    fun increase (value: Int): Int {
        will.increase(value)
        return will.getWillPower()
    }

    fun decrease (value: Int): Int {
        will.decrease(value)
        return will.getWillPower()
    }

    fun save () {
        willBox.put(will)
    }
}