package com.droid.alex.willtrip.ui


import android.app.Dialog
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.adapter.DoAdapter
import com.droid.alex.willtrip.model.Do
import kotlinx.android.synthetic.main.fragment_do_list.*
import android.support.v7.widget.DividerItemDecoration
import com.droid.alex.willtrip.App
import io.objectbox.Box
import io.objectbox.kotlin.boxFor


class DoListFragment : Fragment(), DoAdapter.OnDoEditClickListener {

    private lateinit var doBox: Box<Do>

    override fun onEditClicked(position: Int, rect: Rect) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.edit_dialog)
        dialog.show()
    }

    companion object {
        val CREATE_DO_REQUEST = 1
    }

    private lateinit var listener: DoAdapter.OnDoEditClickListener
    var arrayOfDo = mutableListOf<Do>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_do_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = DoAdapter(arrayOfDo, context, this)
        val itemAnimator = DefaultItemAnimator()
        itemAnimator.addDuration = 650
        itemAnimator.changeDuration = 650
        itemAnimator.removeDuration = 650
        recyclerView.itemAnimator = itemAnimator
        recyclerView.hasFixedSize()
        if (arrayOfDo.size == 0) empty_view.visibility = View.VISIBLE

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.getOrientation())
        recyclerView.addItemDecoration(dividerItemDecoration)

        fab.setOnClickListener {
            val intent = Intent(context, CreateDoActivity::class.java)
            startActivityForResult(intent, CREATE_DO_REQUEST)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        doBox = (activity.application as App).getBoxStore().boxFor(Do::class.java)
        if (doBox.count() > 0) {
            val doDays = doBox.all
            arrayOfDo = doDays
        }
        recyclerView.adapter = DoAdapter(arrayOfDo, context, this)
        empty_view.visibility = View.INVISIBLE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == CREATE_DO_REQUEST) {
            if (resultCode == AppCompatActivity.RESULT_OK) {
                val newDoId = data?.getLongExtra(CreateDoActivity.NEW_DO_OBJECT_ID, -1L)

                if (newDoId != null && newDoId != -1L) {

                    if (empty_view.visibility == View.VISIBLE) empty_view.visibility = View.INVISIBLE

                            val newDo = doBox.get(newDoId)
                            arrayOfDo.add(newDo)
                            recyclerView.scrollToPosition(arrayOfDo.size - 1)
                            recyclerView.adapter.notifyItemInserted(arrayOfDo.size - 1)
                        }
                    }
                }
            }
        }




