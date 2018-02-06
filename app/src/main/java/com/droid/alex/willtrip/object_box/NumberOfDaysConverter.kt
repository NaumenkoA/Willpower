package com.droid.alex.willtrip.object_box

import io.objectbox.converter.PropertyConverter

class NumberOfDaysConverter : PropertyConverter <ArrayList<Int>, String> {
    override fun convertToDatabaseValue(entityProperty: ArrayList<Int>): String {
        var propertyAsString = ""
        for (item in entityProperty) {
            propertyAsString += item.toString()
        }
        return propertyAsString
    }

    override fun convertToEntityProperty(databaseValue: String): ArrayList<Int> {
        var array: ArrayList <Int> = ArrayList(7)
        var i = 0
        while (i < databaseValue.length) {
            array [i] = databaseValue [i].toInt()
            i++
        }
        return array
    }
}