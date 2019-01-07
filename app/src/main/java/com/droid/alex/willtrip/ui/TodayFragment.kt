package com.droid.alex.willtrip.ui


import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.adapter.TodayDoAdapter
import com.droid.alex.willtrip.model.core.DateDoLoader
import com.droid.alex.willtrip.model.core.Do
import com.droid.alex.willtrip.model.story.Obstacle
import com.droid.alex.willtrip.model.story.ObstacleLoader
import com.droid.alex.willtrip.model.story.ObstacleResolver
import com.droid.alex.willtrip.model.story.SceneManager
import com.droid.alex.willtrip.model.will.WillPower
import com.droid.alex.willtrip.object_box.DoDBHelper
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.fragment_today.*
import org.joda.time.DateTime
import org.joda.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList


class TodayFragment : Fragment() {

    private val targetWP = 600
    private lateinit var selectedDay: DateTime
    private val sceneManager by lazy {
        SceneManager(context!!)
    }
    private val obstacleResolver = ObstacleResolver()
    private val obstacleLoader = ObstacleLoader()
    private lateinit var dateLoader:DateDoLoader

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var doList = ArrayList <Do>()
        if (DoDBHelper().loadAll().count() != 0) doList = DoDBHelper().loadAll() as ArrayList<Do>
        if (doList.count() == 0) doList = ArrayList ()
        dateLoader = DateDoLoader (doList)
        val currentDate = Calendar.getInstance().time

        selectedDay = DateTime(currentDate)

        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        loadCurrentDoList()

        previousDayButton.setOnClickListener {
            onPreviousDayButtonClicked()
        }

        nextDayButton.setOnClickListener {
            onNextDayButtonClicked()
        }

        setChartSettings()
        setupPieData()
    }

    private fun onPreviousDayButtonClicked() {
        selectedDay = selectedDay.minusDays(1)
        notifySelectedDateChanged()
    }

    private fun onNextDayButtonClicked() {
        selectedDay = selectedDay.plusDays(1)
        notifySelectedDateChanged()
    }

    private fun notifySelectedDateChanged() {
        setSelectedDateLabel()
        setCollapsingToolbarParams()
        setDoListContent()
    }

    private fun setDoListContent() {
        val currentDate = LocalDate()
        when (selectedDay.toLocalDate()) {
            in LocalDate (Long.MIN_VALUE) .. currentDate.minusDays(1) -> loadListContent (DayType.Past)
            in currentDate.plusDays(1) .. LocalDate (Long.MAX_VALUE) -> loadListContent (DayType.Future)
            else -> loadListContent (DayType.Today)
        }
    }

    private fun loadListContent(dayType: TodayFragment.DayType) {
        when (dayType) {
            DayType.Today -> loadPastDoList()
            DayType.Past -> loadCurrentDoList()
            DayType.Future -> loadFutureDoList()
        }
    }

    private fun loadCurrentDoList() {
        dateLoader.date = Calendar.getInstance().time
        recyclerView.adapter = TodayDoAdapter(dateLoader.getTodayDoList(), context!!)
    }

    private fun loadPastDoList() {

    }


    private fun loadFutureDoList() {
        recyclerView.adapter = FutureDoAdapter(dateLoader.getTodayDoList(), context!!)
    }

    private fun setCollapsingToolbarParams() {
        collapsingToolbar.title = selectedDayLabel.text
        collapsingToolbar.setExpandedTitleColor(ContextCompat.getColor(context!!, android.R.color.transparent))
        }

    private fun setSelectedDateLabel() {
        when (selectedDay.toLocalDate()) {
            LocalDate() -> setDateTextViewLabel(getString(R.string.today))
            LocalDate().minusDays(1) -> setDateTextViewLabel(getString(R.string.yesterday))
            LocalDate().plusDays(1) -> setDateTextViewLabel(getString(R.string.tomorrow))
            else -> setDateTextViewLabel(selectedDay.toString("MMMM dd", Locale.US))
        }
    }

    private fun setDateTextViewLabel(label: String) {
        selectedDayLabel.text = label
    }

    private fun setChartSettings() {
        pieChart.legend.isEnabled = false
        pieChart.description.isEnabled = false
        pieChart.setTouchEnabled(false)
        pieChart.setDrawEntryLabels(false)
        pieChart.holeRadius = 60f
        pieChart.setCenterTextSize(36f)
        pieChart.setCenterTextTypeface(Typeface.DEFAULT_BOLD)
    }

    private fun setupPieData() {
        val currentWP = WillPower.power()
        val nextLevelWP = getCurrentObstacleWP()
        val leftToNextLevel = if (nextLevelWP - currentWP > 0)  (nextLevelWP - currentWP)else 0
        val leftToTargetLevel = if (targetWP - currentWP - leftToNextLevel > 0)  (targetWP - currentWP - leftToNextLevel)else 0

        pieChart.setCenterTextColor(getCurrentWPColor(currentWP, targetWP))

        val pieEntries: MutableList <PieEntry> = mutableListOf()
        pieEntries.add(PieEntry (currentWP.toFloat(), getString(R.string.wp)))
        pieEntries.add(PieEntry (leftToNextLevel.toFloat(), getString(R.string.to_next_level)))
        pieEntries.add(PieEntry (leftToTargetLevel.toFloat()))

        val dataSet = PieDataSet (pieEntries, "WP data")
        dataSet.colors = mutableListOf(getCurrentWPColor(currentWP, targetWP),
                ContextCompat.getColor(context!!, R.color.colorGrey),
                ContextCompat.getColor(context!!, R.color.colorLightGrey))

        dataSet.setDrawValues(false)

        pieChart.data = PieData (dataSet)
        pieChart.centerText = "$currentWP WP"
        pieChart.data.isHighlightEnabled = false

        pieChart.invalidate()
    }

    private fun getCurrentWPColor(currentWP: Int, targetWP: Int): Int {
        val completion = (currentWP*100/targetWP)
        return when (completion) {
            in 0..9 -> Color.parseColor("#96c7f4")
            in 10..19 -> Color.parseColor("#84bdf3")
            in 20..29 -> Color.parseColor("#72b4f1")
            in 30..39 -> Color.parseColor("#61abef")
            in 40..49 -> Color.parseColor("#50a2ee")
            in 50..59 -> Color.parseColor("#4891d6")
            in 60..69 -> Color.parseColor("#4081be")
            in 70..79 -> Color.parseColor("#3871a6")
            in 80..89 -> Color.parseColor("#30618e")
            else -> Color.parseColor("#285177")
        }
    }

    private fun getCurrentObstacleWP(): Int {
        val obstacles = sceneManager.getCurrentObstacleIds()
        if (obstacles.size == 0) return 0
        obstacles.forEach {
            if (!obstacleResolver.resolved(it)) {
                        val obstacle = obstacleLoader.findObstacle(it)
                        if (obstacle.type == Obstacle.WP) return obstacle.value!!
                    }
        }
        return 0
    }

    enum class DayType {
        Past, Today, Future
    }
}
