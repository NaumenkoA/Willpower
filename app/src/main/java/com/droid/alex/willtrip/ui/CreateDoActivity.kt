package com.droid.alex.willtrip.ui

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.extension_func.setColor
import com.droid.alex.willtrip.model.DayOfWeek
import com.droid.alex.willtrip.model.Do
import com.droid.alex.willtrip.presenter.CreateDoPresenter
import com.droid.alex.willtrip.views.RoundButton
import kotlinx.android.synthetic.main.activity_create_do.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CreateDoActivity : AppCompatActivity(), CreateDoPresenter.CreateDoView {

    override fun showSnackBarMessage(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCommitmentTitle(): String? {

    }

    override fun getComplexity(): Int? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStartDate(): Date {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getExpireDate(): Date? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDaysMode(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSelectedDaysOfWeek(): ArrayList<DayOfWeek>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTimesAWeekValue(): Int? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRepeatValue(): Int? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun returnResult(doId: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val SELECT_START_DATE_REQUEST = 2
        val SELECT_END_DATE_REQUEST = 3
        val MODE_SELECT_DAYS = "mode_select_days"
        val MODE_SELECT_DAYS_A_WEEK = "mode_select_days_a_week"
        val MODE_SELECT_REPEAT_PERIOD = "mode_select_repeat_period"
        val NEW_DO_OBJECT = "new_do_object"
    }

    private val presenter = CreateDoPresenter (this)
    private lateinit var dayButtonArray: ArrayList<RoundButton>
    private var selectedCompButton: RoundButton? = null
    private var selectedNumButton: RoundButton? = null
    private lateinit var complexityButtonArray: ArrayList<RoundButton>
    private var isPositiveButtonSelected: Boolean = true
    private var mode: String = MODE_SELECT_DAYS
    private val dateFormatter = SimpleDateFormat("d MMM yyyy", Locale.US)
    var startDateValue: Date = Calendar.getInstance().time
    var expireDateValue: Date? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_do)

        descriptionEditText.setHorizontallyScrolling(false);
        descriptionEditText.maxLines = Integer.MAX_VALUE;

        complexityButtonArray = arrayListOf<RoundButton>(roundButtonVeryEasy, roundButtonEasy, roundButtonMedium, roundButtonHard, roundButtonVeryHard)
        dayButtonArray = arrayListOf<RoundButton>(roundButton1, roundButton2, roundButton3, roundButton4, roundButton5, roundButton6, roundButton7)

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
            startActivityForResult (intent, CreateDoActivity.SELECT_START_DATE_REQUEST)
        }

        endDateCalendarButton.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            intent.putExtra(CalendarActivity.IS_TEXT_HINT_VISIBLE, true)

            val minDate = startDate.time + 1*24*60*60*1000
            intent.putExtra(CalendarActivity.MIN_DATE, minDate)
            startActivityForResult (intent, CreateDoActivity.SELECT_END_DATE_REQUEST)
        }

        for (button in complexityButtonArray) {
            button.setOnClickListener {
                if (button != selectedCompButton) {
                    selectedCompButton?.swap()
                    selectedCompButton = button
                    selectedCompButton?.swap()
                }
            }
        }

        dayTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

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
                        for (button in dayButtonArray) {
                            button.selectedState = true
                            }
                        }
                }
            }
        }

        createButton.setOnClickListener {

//                val numOfDaysArray = arrayListOf<Byte>()
//                var index = 0
//                for (button in dayButtonArray) {
//                    if (button.selectedState) {
//                        numOfDaysArray.add(index.toByte())
//                    }
//                    index++
//                }

                presenter.onCreateButtonClicked ()

//            mode = dayTypeSpinner.selectedItemPosition, title = titleEditText.text.toString(),
//            desc = descriptionEditText.text.toString(), isPositive = isPositiveButtonSelected, startDate = startDate,
//            expireDate = expireDate, complexity = selectedCompButton?.text.toString()
                }
        }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECT_START_DATE_REQUEST|| requestCode == SELECT_END_DATE_REQUEST) {
            if (resultCode == RESULT_OK) {
                val selectedDate = data?.getSerializableExtra(CalendarActivity.SELECTED_DATE) as Date?
                if (selectedDate!= null) {
                    if (requestCode == SELECT_START_DATE_REQUEST) {
                        startDate = selectedDate
                        startDateTextView.text = dateFormatter.format(startDate)
                    } else {
                        expireDate = selectedDate
                        expireDateTextView.text = dateFormatter.format(expireDate)
                    }
                }
            }
            }
        }

    private fun sendCreatedDoObj (newDo: Do) {
        val returnIntent = Intent()
        val doBox = (application as App).getBoxStore().boxFor(Do::class.java)
        doBox.put(newDo)
        returnIntent.putExtra(NEW_DO_OBJECT, newDo.id)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }


    private fun hideKeyboardFrom(view: View) {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun setDaysSelectionMode (mode: String) {
        when (mode) {
            MODE_SELECT_DAYS -> {
                val dayNameArray = resources.getStringArray(R.array.days_of_week)
                setDaysLayoutVisible(true)
                for (i in 0 until dayButtonArray.size) {
                    dayButtonArray [i].text = dayNameArray [i]
                    dayButtonArray [i].setOnClickListener {
                        dayButtonArray [i].swap()
                    }
                    dayButtonArray [i].selectedState = false
                }
               }
            MODE_SELECT_DAYS_A_WEEK -> {
                setDaysLayoutVisible(true)
                for (i in 0 until dayButtonArray.size) {
                    dayButtonArray [i].text = ((i + 1).toString())
                    dayButtonArray [i].setOnClickListener {
                        if (dayButtonArray [i] != selectedNumButton) {
                            selectedNumButton?.swap()
                            selectedNumButton = dayButtonArray [i]
                            selectedNumButton?.swap()
                        }
                    }
                    selectedNumButton = null
                    dayButtonArray [i].selectedState = false
                }
            }
            MODE_SELECT_REPEAT_PERIOD -> {
                setDaysLayoutVisible(false)
            }
            else -> throw IllegalArgumentException ("Wrong entry parameter in setDaysSelectionMode function")
        }
        daysMode = mode
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
}



