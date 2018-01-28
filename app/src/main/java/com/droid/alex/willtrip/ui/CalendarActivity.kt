package com.droid.alex.willtrip.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.droid.alex.willtrip.R
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*
import android.app.Activity
import android.content.Intent
import android.view.View
import com.droid.alex.willtrip.extension_func.getDate


class CalendarActivity : AppCompatActivity() {

    companion object {
        val SELECTED_DATE = "selected_date"
        val MIN_DATE = "min_date"
        val IS_TEXT_HINT_VISIBLE = "is_text_hint_visible"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val isTextHintVisible = intent.getBooleanExtra(IS_TEXT_HINT_VISIBLE, false)
        if (isTextHintVisible) textHint.visibility = View.VISIBLE
        else textHint.visibility = View.INVISIBLE

        datePicker.minDate = intent.getLongExtra(MIN_DATE, Calendar.getInstance().timeInMillis)

        submitButton.setOnClickListener {

            val returnIntent = Intent()
            returnIntent.putExtra(SELECTED_DATE, datePicker.getDate())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
