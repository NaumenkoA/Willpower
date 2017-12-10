package com.droid.alex.willtrip.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import android.app.Activity
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import com.droid.alex.willtrip.extension_func.setColor
import kotlinx.android.synthetic.main.fragment_create_do.*
import android.widget.ArrayAdapter
import com.droid.alex.willtrip.views.RoundButton
import java.text.SimpleDateFormat
import java.util.*


class CreateDoFragment : Fragment() {

    private lateinit var dayButtonArray: ArrayList <RoundButton>
    private var selectedCompButton: RoundButton? = null
    private var selectedNumButton: RoundButton? = null
    private lateinit var complexityButoonArray: ArrayList <RoundButton>
    private var isPositive: Boolean = true
    private var buttonsAsDays: Boolean = true
    var expireDate: Date? = null

    private lateinit var listener: OnDateSelectionListener

    interface OnDateSelectionListener {
        fun onDateSelection ()
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_create_do, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        listener = activity as OnDateSelectionListener

        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        descriptionEditText.setHorizontallyScrolling(false);
        descriptionEditText.maxLines = Integer.MAX_VALUE;

        complexityButoonArray = arrayListOf<RoundButton>(roundButtonVeryEasy, roundButtonEasy, roundButtonMedium, roundButtonHard, roundButtonVeryHard)
        dayButtonArray = arrayListOf<RoundButton>(roundButton1, roundButton2, roundButton3, roundButton4, roundButton5, roundButton6, roundButton7)

        // create adapter for spinner
        val adapter = ArrayAdapter <String>(context, R.layout.spinner_item, context.resources.getStringArray(R.array.day_types))
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
            if (!isPositive) {
                isPositive = true
                negativeButton.setColor (context, R.color.colorLightGrey)
                positiveButton.setColor (context, R.color.colorGreen)
            }
        })

        negativeButton.setOnClickListener({
            if (isPositive) {
                isPositive = false
                negativeButton.setColor (context, R.color.colorLightRed)
                positiveButton.setColor (context, R.color.colorLightGrey)
            }
        })

        clearButton.setOnClickListener {
            expireDate = null
            expireDateTextView.text = context.resources.getString(R.string.infinite)
        }

        calendarButton.setOnClickListener {
            listener.onDateSelection()
        }

        for (button in complexityButoonArray) {
            button.setOnClickListener {
               if (button!= selectedCompButton) {
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
                       for (button in dayButtonArray) {
                           button.setOnClickListener {
                               button.swap()
                           }
                           button.setSelectedState(false)
                       }
                       buttonsAsDays = true
                    }

                    1 -> {
                        for (button in dayButtonArray) {
                            button.setOnClickListener {
                            if (button!= selectedNumButton) {
                                selectedNumButton?.swap()
                                selectedNumButton = button
                                selectedNumButton?.swap()
                            }
                            }
                            button.setSelectedState(false)
                            selectedNumButton = null
                        }
                        buttonsAsDays = false
                    }

                    2 -> {
                        for (button in dayButtonArray) {
                            button.setOnClickListener {
                                button.swap()
                            }
                            button.setSelectedState(true)
                        }
                        buttonsAsDays = true
                    }
                }
                showButtonsAsDays()
            }

        }

        super.onViewCreated(view, savedInstanceState)
    }


    override fun onResume() {
            if (expireDate != null) {
                val dateFormatter = SimpleDateFormat("d MMM yyyy", Locale.US)
                expireDateTextView.text = dateFormatter.format(expireDate)
            }
        super.onResume()
    }

    private fun showButtonsAsDays () {
        if (buttonsAsDays) {
            val dayNameArray = context.resources.getStringArray(R.array.days_of_week)
            for (i in 0 until dayButtonArray.size) {
                dayButtonArray [i].text = dayNameArray [i]
            }
        } else {
            for (i in 0 until dayButtonArray.size) {
                dayButtonArray [i].text = (i + 1).toString()
            }
        }
    }

    private fun hideKeyboardFrom(view: View) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
