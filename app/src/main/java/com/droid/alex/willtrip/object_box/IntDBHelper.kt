package com.droid.alex.willtrip.object_box

import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.model.story.Scene

class IntDBHelper {
    private val intBox = App.instance.getBoxStore().boxFor(IntValue::class.java)

    fun getInt (id: Long): Int {
        val intValue = intBox.get (id) ?: return 0
        return intValue.value
    }

    fun saveInt (id: Long, value: Int) {
        intBox.put(IntValue(id, value))
    }
}