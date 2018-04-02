package com.droid.alex.willtrip.model.will

import android.annotation.SuppressLint
import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.object_box.IntDBHelper
import com.droid.alex.willtrip.object_box.IntValue

object WillPower {

    private val intBox = App.instance.getBoxStore().boxFor(IntValue::class.java)

    private val dbHelper = IntDBHelper ()
    private val will = Will (dbHelper.getIntOrZero(1))

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
       dbHelper.saveInt(1, will.getWillPower())
    }
  }