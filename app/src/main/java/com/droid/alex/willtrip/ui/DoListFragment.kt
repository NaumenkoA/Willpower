package com.droid.alex.willtrip.ui


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.adapter.DoAdapter
import com.droid.alex.willtrip.model.Do
import com.droid.alex.willtrip.model.DoDays
import kotlinx.android.synthetic.main.fragment_do_list.*
import java.util.*


class DoListFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_do_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val doDays1 = DoDays (complexity = 2, name = "Get up at 6:00", note = "Become early bird", isPositive = false, expireDate = null, numberOfDays = arrayListOf(0,5,6))

        val arrayOfDo = arrayListOf<Do>(doDays1)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = DoAdapter (arrayOfDo, context)

        fab.setOnClickListener {
            val intent = Intent(context, CreateDoActivity::class.java)
            startActivityForResult (intent, MainActivity.CREATE_DO_REQUEST)
        }
    }
}
