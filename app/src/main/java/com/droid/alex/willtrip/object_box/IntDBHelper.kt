package com.droid.alex.willtrip.object_box

import com.droid.alex.willtrip.App

class IntDBHelper {
    private val intBox = App.instance.getBoxStore().boxFor(IntValue::class.java)

     fun getInt (link: Int): Int? {
        val intQueryBuilder =  intBox.query()
        val intValue = intQueryBuilder.equal(IntValue_.link, link.toLong()).build().findUnique()
        return intValue?.value
    }

    private fun getIntValue (link: Int): IntValue? {
        val intQueryBuilder =  intBox.query()
        return intQueryBuilder.equal(IntValue_.link, link.toLong()).build().findUnique()
    }

    fun saveInt (link: Int, value: Int) {
        val intValue = getIntValue(link)
        if (intValue == null)  intBox.put(IntValue(link = link, value = value))
        else intBox.put(IntValue(id = intValue.id,link = link, value = value))
    }

    fun getIntOrZero(link: Int): Int {
        val intQueryBuilder =  intBox.query()
        val intValue = intQueryBuilder.equal(IntValue_.link, link.toLong()).build().findUnique()
        return intValue?.value ?: 0
    }
}