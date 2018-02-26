package com.droid.alex.willtrip.ui

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.extension_func.setColor
import com.droid.alex.willtrip.model.DayOfWeek
import com.droid.alex.willtrip.model.Do
import com.droid.alex.willtrip.presenter.CreateDoPresenter
import com.droid.alex.willtrip.views.round_button.RoundButton
import com.droid.alex.willtrip.views.round_button.RoundButtonGroup
import kotlinx.android.synthetic.main.activity_create_do.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CreateDoActivity : AppCompatActivity(), CreateDoPresenter.CreateDoView {

    companion object {
        val SELECT_START_DATE_REQUEST = 2
        val SELECT_END_DATE_REQUEST = 3
        val MODE_SELECT_DAYS = "mode_select_days"
        val MODE_SELECT_DAYS_A_WEEK = "mode_select_days_a_week"
        val MODE_SELECT_REPEAT_PERIOD = "mode_select_repeat_period"
        val NEW_DO_OBJECT_ID = "new_do_object_id"
    }

    private lateinit var presenter: CreateDoPresenter
    private lateinit var dayButtonGroup: RoundButtonGroup
    private lateinit var complexityButtonGroup: RoundButtonGroup
    private lateinit var dayButtonArray: ArrayList <RoundButton>
    private var isPositiveButtonSelected: Boolean = true
    private var mode: String = MODE_SELECT_DAYS
    private val dateFormatter = SimpleDateFormat("d MMM yyyy", Locale.US)
    var startDateValue: Date = Calendar.getInstance().time
    var expireDateValue: Date? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_do)

        presenter = CreateDoPresenter (this)

        descriptionEditText.setHorizontallyScrolling(false);
        descriptionEditText.maxLines = Integer.MAX_VALUE;

        val complexityButtonArray = arrayListOf<RoundButton>(roundButtonVeryEasy, roundButtonEasy, roundButtonMedium, roundButtonHard, roundButtonVeryHard)
        complexityButtonGroup = RoundButtonGroup(complexityButtonArray, false)

        dayButtonArray = arrayListOf<RoundButton>(roundButton1, roundButton2, roundButton3, roundButton4, roundButton5, roundButton6, roundButton7)
        dayButtonGroup = RoundButtonGroup(dayButtonArray, true)

        //set start date by default
        startDateTextView.text = dateFormatter.format(Calendar.getInstance().time)

        // create adapter for spinner
        val adapter = ArrayAdapter<String>(this, R.layout.spinner_item, resources.getStringArray(R.array.day_types))
        dayTypeSpinner.adapter = adapter
        dayTypeSpinner.setSelection(0)

        // set onClick and Editor listeners
        titleEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                descriptionEditText.requestFocus()
            }
            actionId == EditorInfo.IME_ACTION_DONE
        }

        descriptionEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                hideKeyboardFrom(descriptionEditText)
                descriptionEditText.clearFocus()
            }
            actionId == EditorInfo.IME_ACTION_DONE
        }

        positiveButton.setOnClickListener({
            if (!isPositiveButtonSelected) {
                isPositiveButtonSelected = true
                negativeButton.setColor(this, R.color.colorLightGrey)
                positiveButton.setColor(this, R.color.colorGreen)
            }
        })

        negativeButton.setOnClickListener({
            if (isPositiveButtonSelected) {
                isPositiveButtonSelected = false
                negativeButton.setColor(this, R.color.colorLightRed)
                positiveButton.setColor(this, R.color.colorLightGrey)
            }
        })

        clearButton.setOnClickListener {
            expireDateTextView.text = resources.getString(R.string.infinite)
        }

        startDateCalendarButton.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivityForResult(intent, CreateDoActivity.SELECT_START_DATE_REQUEST)
        }

        endDateCalendarButton.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            intent.putExtra(CalendarActivity.IS_TEXT_HINT_VISIBLE, true)

            val minDate = startDateValue.time + 1 * 24 * 60 * 60 * 1000
            intent.putExtra(CalendarActivity.MIN_DATE, minDate)
            startActivityForResult(intent, CreateDoActivity.SELECT_END_DATE_REQUEST)
        }


        dayTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        setDaysSelectionMode(MODE_SELECT_DAYS)
                    }

                    1 -> {
                        setDaysSelectionMode(MODE_SELECT_DAYS_A_WEEK)
                    }

                    2 -> {
                        setDaysSelectionMode(MODE_SELECT_REPEAT_PERIOD)
                    }

                    3 -> {
                        setDaysSelectionMode(MODE_SELECT_DAYS)
                        dayButtonGroup.selectAll()
                    }
                }
            }
        }


        createButton.setOnClickListener {
            presenter.onCreateButtonClicked()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECT_START_DATE_REQUEST|| requestCode == SELECT_END_DATE_REQUEST) {
            if (resultCode == RESULT_OK) {
                val selectedDate = data?.getSerializableExtra(CalendarActivity.SELECTED_DATE) as Date?
                if (selectedDate!= null) {
                    if (requestCode == SELECT_START_DATE_REQUEST) {
                        startDateValue = selectedDate
                        startDateTextView.text = dateFormatter.format(startDateValue)
                    } else {
                        expireDateValue = selectedDate
                        expireDateTextView.text = dateFormatter.format(expireDateValue)
                    }
                }
            }
            }
        }

    private fun hideKeyboardFrom(view: View) {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun setDaysSelectionMode (mode: String) {
        when (mode) {
            MODE_SELECT_DAYS -> {

                setDaysLayoutVisible(true)
                dayButtonGroup.setMultichoiceEnabled(true)

                val dayNameArray = resources.getStringArray(R.array.days_of_week)
                val dayButtonArray = dayButtonGroup.buttonList
                for (i in 0 until dayButtonArray.size) {
                    dayButtonArray [i].text = dayNameArray [i]
                    }
                    dayButtonGroup.clearSelection()
                }

            MODE_SELECT_DAYS_A_WEEK -> {

                setDaysLayoutVisible(true)

                dayButtonGroup.setMultichoiceEnabled(false)

                val dayNumButtonArray = dayButtonGroup.buttonList

                for (i in 0 until dayNumButtonArray.size) {
                    dayNumButtonArray [i].text = ((i + 1).toString())
                }
                    dayButtonGroup.clearSelection()
                }

            MODE_SELECT_REPEAT_PERIOD -> {
                setDaysLayoutVisible(false)
            }

            else -> throw IllegalArgumentException ("Wrong entry parameter in setDaysSelectionMode function")
        }
        this.mode = mode
    }

    private fun setDaysLayoutVisible (isVisible: Boolean) {
        val currentVisibility = (daysLayout.visibility == View.VISIBLE)

        if (currentVisibility != isVisible) {
            if (isVisible) {
                daysLayout.visibility = View.VISIBLE
                repeatNumLayout.visibility = View.INVISIBLE
            }
            else {
                daysLayout.visibility = View.INVISIBLE
                repeatNumLayout.visibility = View.VISIBLE
            }
        }
    }

    override fun showSnackBarMessage(id: Int) {
        Snackbar.make(rootLayout, resources.getString(id), Snackbar.LENGTH_LONG).show()
    }

    override fun getCommitmentTitle(): String? {
        return titleEditText.text.toString().trim()
    }

    override fun getComplexity(): Int? {
        val selectedButton = complexityButtonGroup.getSelectedButtons()
        return if (selectedButton.size == 0) null
        else selectedButton [0].text.toString().toInt()
    }

    override fun getStartDate(): Date {
        return startDateValue
    }

    override fun getExpireDate(): Date? {
        return expireDateValue
    }

    override fun getDaysMode(): String {
        return mode
    }

    override fun getSelectedDaysOfWeek(): Array<DayOfWeek>? {
        val selectedDayButtonArray = dayButtonGroup .getSelectedButtons()
        val selectedDayArray = arrayListOf<DayOfWeek>()
        val weekDays = resources.getStringArray(R.array.days_of_week)

        for (button in selectedDayButtonArray) {

                val dayIndex = weekDays
                        .takeWhile { button.text.toString() != it }
                        .count()

            selectedDayArray.add(DayOfWeek.values() [dayIndex])
        }

        return if (selectedDayArray.size == 0)  null
        else {
            val array = arrayOfNulls<DayOfWeek>(selectedDayArray.size)
            selectedDayArray.toArray(array)
        }
    }

    override fun getTimesAWeekValue(): Int? {
        val selectedButton = dayButtonGroup.getSelectedButtons()

        return if (selectedButton.size == 0) null
        else selectedButton[0].text.toString().toInt()
    }

    override fun getRepeatValue(): Int? {
        return if (repeatNumEditText.text.isNullOrBlank()) null
        else repeatNumEditText.text.toString().toInt()
    }

    override fun returnResult(newItemId: Long) {
        val resultIntent = Intent ()
        resultIntent.putExtra(NEW_DO_OBJECT_ID, newItemId)
        this.setResult(android.app.Activity.RESULT_OK, resultIntent)
        finish()
    }

    override fun getIsPositive(): Boolean {
       return isPositiveButtonSelected
    }

    override fun getSpecialDaysEnabled(): Boolean {
        return specialDaysSwitch.isChecked
    }

    override fun getDescription(): String? {
        val description = descriptionEditText.text.toString().trim()
        if (description == "") return null
        else return description
    }
}



