package com.droid.alex.willtrip.model.core

import com.droid.alex.willtrip.model.Do
import com.droid.alex.willtrip.model.period.PeriodDays
import com.droid.alex.willtrip.model.period.PeriodNumWeek
import com.droid.alex.willtrip.model.period.PeriodRepeat
import com.droid.alex.willtrip.model.will.TodayDo
import org.joda.time.DateTimeConstants
import org.joda.time.Days
import org.joda.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class DateDoLoader (val doList: ArrayList <Do>) {

private lateinit var actualDoList: ArrayList <Do>
private lateinit var localDate: LocalDate
private val resultDBHelper = ResultDBHelper()

private var date: Date = Calendar.getInstance().time
    set(value) {
    localDate = LocalDate(value)
    actualDoList = getActualDoList(doList)
}

    private fun getActualDoList (doList: ArrayList <Do>): ArrayList <Do> {
        val actualList = arrayListOf<Do>()

        for (doObj in doList) {
            var isActual = true
            val startDate = LocalDate(doObj.startDate)
            val expireDate = LocalDate(doObj.expireDate)
            if (localDate !in startDate..expireDate) isActual = false
            if (resultDBHelper.loadResultForDate(doObj, localDate.toDate()) != null) isActual = false
            if (isActual) actualList.add(doObj)
        }
        return actualList
    }

        fun getTodayDoList(): ArrayList<TodayDo> {

            val todayDoArray: ArrayList<TodayDo> = arrayListOf()
            val currentDayIndex = localDate.dayOfWeek().get()

            for (doObj in actualDoList) {
                val period = doObj.period
                when (period) {

                    is PeriodDays -> {
                        if (period.containsDay(currentDayIndex)) todayDoArray.add(TodayDo(doObj, true))
                    }

                    is PeriodNumWeek -> {
                        val results = resultDBHelper.loadResultsForPeriod(doObj, localDate.withDayOfWeek(DateTimeConstants.MONDAY).toDate(),
                                localDate.withDayOfWeek(DateTimeConstants.SUNDAY).toDate())
                        val daysLeft = Days.daysBetween(localDate, localDate.withDayOfWeek(DateTimeConstants.SUNDAY)).days + 1
                        val resultsLeft = period.numWeek - results.size
                        if ((resultsLeft > 0) && (resultsLeft >= daysLeft)) todayDoArray.add(TodayDo(doObj, true))
                        else if (resultsLeft > 0) todayDoArray.add(TodayDo(doObj, false))
                    }

                    is PeriodRepeat -> {
                        val lastResultDate = resultDBHelper.getLatestResult(doObj, localDate.toDate())?.date
                        if (lastResultDate == null) todayDoArray.add(TodayDo(doObj, true))
                        else {
                            val distance = Days.daysBetween(LocalDate(lastResultDate), localDate).days
                            if (distance >= period.repeatNum) todayDoArray.add(TodayDo(doObj, true))
                            else todayDoArray.add(TodayDo(doObj, false))
                        }
                    }
                }
            }
            todayDoArray.sortWith(compareBy(TodayDo::isObligatory, TodayDo::willPoint))
            return todayDoArray
        }
    }
