package com.droid.alex.willtrip.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.adapter.TodayDoAdapter
import com.droid.alex.willtrip.model.core.DateDoLoader
import com.droid.alex.willtrip.model.core.Do
import com.droid.alex.willtrip.object_box.DoDBHelper
import kotlinx.android.synthetic.main.fragment_do_list.*
import java.util.*
import kotlin.collections.ArrayList


class TodayFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var doList = ArrayList <Do>()
        if (DoDBHelper().loadAll().count() != 0) doList = DoDBHelper().loadAll() as ArrayList<Do>
        if (doList.count() == 0) doList = ArrayList <Do> ()
        val todayLoader = DateDoLoader (doList)
        todayLoader.date = Calendar.getInstance().time

        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = TodayDoAdapter(todayLoader.getTodayDoList(), context!!)
    }
}
