package com.droid.alex.willtrip.model.will

import com.droid.alex.willtrip.App

object WillPower {

    private val willBox = App.instance.getBoxStore().boxFor(Will::class.java)

    private val will = willBox.get(1)

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