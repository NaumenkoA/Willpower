package com.droid.alex.willtrip.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.droid.alex.willtrip.R
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*
import android.app.Activity
import android.content.Intent
import com.droid.alex.willtrip.extension_func.getDate


class CalendarActivity : AppCompatActivity() {

    companion object {
        val SELECTED_DATE = "selected_date"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val calendar = Calendar.getInstance()

        datePicker.minDate = calendar.timeInMillis + 1*24*60*60*1000

        submitButton.setOnClickListener {

            val returnIntent = Intent()
            returnIntent.putExtra(SELECTED_DATE, datePicker.getDate())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
