package com.droid.alex.willtrip.presenter
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.model.DayOfWeek
import com.droid.alex.willtrip.model.Do
import com.droid.alex.willtrip.model.period.*
import com.droid.alex.willtrip.ui.CreateDoActivity
import io.objectbox.BoxStore
import java.util.*
import kotlin.collections.ArrayList

class CreateDoPresenter (val view: CreateDoView): Presenter {

    override fun onCreate() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    fun onCreateButtonClicked() {

        if (view.getCommitmentTitle().isNullOrBlank()) {
            view.showSnackBarMessage(R.string.no_title_message)
            return
        }

        if (view.getComplexity() == null) {
            view.showSnackBarMessage(R.string.no_complexity_message)
            return
        }

        when (view.getDaysMode()) {

            CreateDoActivity.MODE_SELECT_DAYS -> {
                if (view.getSelectedDaysOfWeek() == null) {
                    view.showSnackBarMessage(R.string.no_days_selected_message)
                    return
                }
            }

            CreateDoActivity.MODE_SELECT_DAYS_A_WEEK -> {
                if (view.getTimesAWeekValue() == null) {
                    view.showSnackBarMessage(R.string.no_number_of_times_message)
                    return
                }
            }

            CreateDoActivity.MODE_SELECT_REPEAT_PERIOD -> {
                if (view.getRepeatValue() == null) {
                    view.showSnackBarMessage(R.string.no_repeat_period_message)
                    return
                }
            }
        }

        if (view.getExpireDate() != null && view.getStartDate() > view.getExpireDate()) {
            view.showSnackBarMessage(R.string.data_error_message)
            return
        }

        val period = when (view.getDaysMode()) {
            CreateDoActivity.MODE_SELECT_REPEAT_PERIOD -> PeriodRepeat (view.getRepeatValue()!!)
            CreateDoActivity.MODE_SELECT_DAYS -> PeriodDays (view.getSelectedDaysOfWeek()!!)
            CreateDoActivity.MODE_SELECT_DAYS_A_WEEK -> PeriodNumWeek (view.getTimesAWeekValue()!!)
            else ->  PeriodRepeat (0)
        }

        val newDo = Do (name = view.getCommitmentTitle()!!.trim(), complexity = view.getComplexity()!!, startDate = view.getStartDate(),
                expireDate = view.getExpireDate(), period = period, isPositive = view.getIsPositive(), note = view.getDescription(),
                isSpecialDayEnabled = view.getSpecialDaysEnabled())

        //val newItemId = boxStore.boxFor(Do::class.java).put(newDo)
        view.returnResult(newDo)
    }

    interface CreateDoView {
        fun showSnackBarMessage(id: Int)
        fun getIsPositive (): Boolean
        fun getDescription (): String?
        fun getCommitmentTitle (): String?
        fun getComplexity (): Int?
        fun getStartDate (): Date
        fun getExpireDate (): Date?
        fun getDaysMode (): String
        fun getSelectedDaysOfWeek(): ArrayList <DayOfWeek>?
        fun getTimesAWeekValue(): Int?
        fun getRepeatValue(): Int?
        fun getSpecialDaysEnabled (): Boolean
        fun returnResult (doValue: Do)
    }
}