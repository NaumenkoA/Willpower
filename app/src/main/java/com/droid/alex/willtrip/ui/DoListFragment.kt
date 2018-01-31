package com.droid.alex.willtrip.ui


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.adapter.DoAdapter
import com.droid.alex.willtrip.model.do_class.Do
import com.droid.alex.willtrip.model.do_class.DoDays
import com.droid.alex.willtrip.model.do_class.DoNum
import com.droid.alex.willtrip.model.do_class.DoPeriodic
import kotlinx.android.synthetic.main.fragment_do_list.*
import java.util.*
import com.droid.alex.willtrip.R.id.recyclerView
import android.support.v7.widget.DividerItemDecoration




class DoListFragment : Fragment() {

    companion object {
        val CREATE_DO_REQUEST = 1
    }

    var arrayOfDo = mutableListOf<Do> ()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_do_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val doDays = DoDays(complexity = 3, name = "Get up at 6:00", note = "Become early bird blah blah blah blah blah blah ", isPositive = true, startDate = Calendar.getInstance().time, expireDate = null, numberOfDays = arrayListOf(0, 5, 6))
        val doNum = DoNum(complexity = 4, name = "Do sports", note = "Do sports three times a week", isPositive = true, startDate = Calendar.getInstance().time, expireDate = null, numberOfDays = 3)
        val doPeriodic = DoPeriodic(complexity = 2, name = "Meditate", note = "Meditate every 2 days", isPositive = false, startDate = Calendar.getInstance().time, expireDate = null, period = 2)

        val arrayOfDo = arrayListOf<Do>(doDays, doNum, doPeriodic)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = DoAdapter(arrayOfDo, context)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.getOrientation())
        recyclerView.addItemDecoration(dividerItemDecoration)



        fab.setOnClickListener {
            val intent = Intent(context, CreateDoActivity::class.java)
            startActivityForResult(intent, CREATE_DO_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == CREATE_DO_REQUEST) {
            if (resultCode == AppCompatActivity.RESULT_OK) {
                val newDo = data?.getParcelableExtra<Do>(CreateDoActivity.NEW_DO_OBJECT)
                if (newDo != null) arrayOfDo.add(newDo)
                recyclerView.adapter.notifyItemInserted(arrayOfDo.size-1)
            }
        }
    }
}
