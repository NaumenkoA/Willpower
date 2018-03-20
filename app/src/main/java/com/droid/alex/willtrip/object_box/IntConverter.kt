package com.droid.alex.willtrip.object_box

import io.objectbox.converter.PropertyConverter

class IntConverter: PropertyConverter<ArrayList <Int>, String> {
    override fun convertToDatabaseValue(entityProperty: ArrayList<Int>): String {
        var string = ""
        if (entityProperty.size == 0) return string
        entityProperty.forEachIndexed { index, i ->
            string += if (index != entityProperty.lastIndex) i.toString() + ","
            else i.toString()
        }
        return string
    }

    override fun convertToEntityProperty(databaseValue: String): ArrayList<Int> {
        val arrayList = ArrayList <Int>()
        if (databaseValue == "") return arrayList
        val listOfString = databaseValue.split(",")
        listOfString.forEachIndexed { index, s -> arrayList.add(index, s.toInt())}
        return arrayList
    }
}