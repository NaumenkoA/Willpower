package com.droid.alex.willtrip.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import kotlinx.android.synthetic.main.fragment_date.*
import java.util.*
import com.droid.alex.willtrip.R.id.datePicker
import com.droid.alex.willtrip.extension_func.getDate


class DateFragment : Fragment() {

    private lateinit var listener: OnDateSelectedListener


    interface OnDateSelectedListener {
        fun onDateSelected (date: Date)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_date, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        val calendar = Calendar.getInstance()

        datePicker.minDate = calendar.timeInMillis + 1*24*60*60*1000

        submitButton.setOnClickListener {
        listener.onDateSelected(datePicker.getDate())
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        listener = activity as OnDateSelectedListener
        super.onActivityCreated(savedInstanceState)
    }
}