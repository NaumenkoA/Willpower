package com.droid.alex.willtrip.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager

import com.droid.alex.willtrip.R
import android.app.Activity
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.droid.alex.willtrip.extension_func.setColor
import kotlinx.android.synthetic.main.fragment_create_do.*
import android.widget.ArrayAdapter
import java.text.SimpleDateFormat
import java.util.*


class CreateDoFragment : Fragment() {

    private var isPositive: Boolean = true
    var expireDate: Date? = null
        set(value) {
            field = value
        }
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

        if (savedInstanceState != null) {
            scrollView.scrollY = savedInstanceState.getInt(SCROLL_Y)
            scrollView.isScrollContainer = false
        }

        // create adapter for spinner
        val adapter = ArrayAdapter <String>(context, R.layout.spinner_item, context.resources.getStringArray(R.array.day_types))
        dayTypeSpinner.adapter = adapter

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
                negativeButton.setColor (context, R.color.colorRed)
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

        super.onViewCreated(view, savedInstanceState)
    }


    override fun onResume() {
        this.activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            if (expireDate != null) {
                val dateFormatter = SimpleDateFormat("d MMM yyyy")
                expireDateTextView.text = dateFormatter.format(expireDate)
            }
        super.onResume()
    }

    fun hideKeyboardFrom(view: View) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    companion object {
        val SELECTED_DATE: String =  "selected_date"
        val SCROLL_Y: String = "scroll_Y"
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(SCROLL_Y, scrollView.scrollY)
    }
}
