package com.droid.alex.willtrip.object_box

import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.model.core.Do
import com.droid.alex.willtrip.model.core.Result
import java.util.*

class ResultDBHelper {

    val doBox = App.instance.getBoxStore().boxFor(Do::class.java)

    fun loadResultsForPeriod (doObj: Do, startDate: Date, endDate: Date): List <Result> {

        return doBox.get(doObj.id).results.filter {
            it.date in startDate..endDate
        }
    }

    fun loadResultForDate (doObj: Do, date: Date): Result? {
        return doBox.get(doObj.id).results.find {
            it.date == date
        }
    }

    fun loadAllResults (doObj: Do): List <Result> {
        return doObj.results
    }

    fun getLatestResult (doObj: Do, date: Date): Result? {
        val resultList = doBox.get(doObj.id).results.takeLast(4).filter { it.date < date }
        resultList.sortedByDescending { it.date }
        return if (resultList.isEmpty()) null
        else resultList [0]
    }
}