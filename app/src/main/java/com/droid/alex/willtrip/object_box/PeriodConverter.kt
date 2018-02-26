package com.droid.alex.willtrip.object_box

import com.droid.alex.willtrip.model.period.Period
import com.droid.alex.willtrip.model.period.PeriodDays
import com.droid.alex.willtrip.model.period.PeriodNumWeek
import com.droid.alex.willtrip.model.period.PeriodRepeat
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import io.objectbox.converter.PropertyConverter

class PeriodConverter : PropertyConverter <Period?, String> {

    private val gson = GsonBuilder().setPrettyPrinting().create()

    override fun convertToDatabaseValue(entityProperty: Period?): String {
        return if (entityProperty == null) ""
        else gson.toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String): Period? {
            return if (String.equals("")) null
        else {
                val type = Gson().fromJson(databaseValue, JsonObject::class.java).get("type").asString

                when (type) {
                    Period.TYPE_DAYS ->  return Gson().fromJson(databaseValue, PeriodDays::class.java)
                    Period.TYPE_TIMES_A_WEEK -> return Gson().fromJson(databaseValue, PeriodNumWeek::class.java)
                    Period.TYPE_PERIODIC -> return Gson().fromJson(databaseValue, PeriodRepeat::class.java)
                    else -> return null
                }
            }
    }
}