package com.droid.alex.willtrip.presenter
import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.model.period.DayOfWeek
import com.droid.alex.willtrip.model.core.Do
import com.droid.alex.willtrip.model.core.Do_
import com.droid.alex.willtrip.model.period.*
import com.droid.alex.willtrip.ui.CreateDoActivity
import java.util.*
import io.objectbox.Box


class CreateDoPresenter (val view: CreateDoView): Presenter {

    private lateinit var doBox: Box<Do>

    override fun onCreate() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    fun onCreateButtonClicked() {

        if (!::doBox.isInitialized) {
            doBox = App.instance.getBoxStore().boxFor(Do::class.java)
        }

        val title = view.getCommitmentTitle()

        if (title.isNullOrBlank()) {
            view.showSnackBarMessage(R.string.no_title_message)
            return
        }

        val builder = doBox.query()

        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        val sameDo = builder.equal(Do_.name, title).build().findFirst()
        if (sameDo != null) {
            view.showSnackBarMessage(R.string.same_title_message)
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
            CreateDoActivity.MODE_SELECT_REPEAT_PERIOD -> PeriodRepeat (repeatNum = view.getRepeatValue()!!)
            CreateDoActivity.MODE_SELECT_DAYS -> PeriodDays (daysOfWeek = view.getSelectedDaysOfWeek()!!)
            CreateDoActivity.MODE_SELECT_DAYS_A_WEEK -> PeriodNumWeek (numWeek = view.getTimesAWeekValue()!!)
            else ->  PeriodRepeat (repeatNum = 0)
        }

        val newDo = Do(name = view.getCommitmentTitle()!!.trim(),
                complexity = view.getComplexity()!!,
                startDate = view.getStartDate(),
                expireDate = view.getExpireDate(),
                isPositive = view.getIsPositive(),
                isSpecialDayEnabled = view.getSpecialDaysEnabled(),
                period = period,
                note = view.getDescription())

        val newItemId = doBox.put(newDo)
        view.returnResult(newItemId)
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
        fun getSelectedDaysOfWeek(): Array <DayOfWeek>?
        fun getTimesAWeekValue(): Int?
        fun getRepeatValue(): Int?
        fun getSpecialDaysEnabled (): Boolean
        fun returnResult (newItemId: Long)
    }
}