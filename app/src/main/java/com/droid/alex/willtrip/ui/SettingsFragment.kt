package com.droid.alex.willtrip.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.model.core.Chain
import com.droid.alex.willtrip.model.will.Will
import com.droid.alex.willtrip.model.will.WillPower
import com.droid.alex.willtrip.object_box.DoDBHelper
import kotlinx.android.synthetic.main.fragment_settings.*
import java.util.*
import kotlin.math.max


class SettingsFragment : Fragment() {

    private val doDBHelper = DoDBHelper()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refresh()
        refreshButton.setOnClickListener { refresh() }

        setWpButton.setOnClickListener {
            setWillPower(wpEditText.text.toString().toInt())
            refresh()
        }
        setChainButton.setOnClickListener {
            setMaxChain(chainEditText.text.toString().toInt())
            refresh()
        }

        clearButton.setOnClickListener { doDBHelper.removeAll()
            refresh()}
    }

    fun getWillPower (): Int = WillPower.power()


    fun setWillPower (power: Int) {
        val diff = power - WillPower.power()
        if (diff > 0) WillPower.increase(diff)
        else WillPower.decrease(diff*(-1))
        WillPower.save()
    }

    fun getCount (): Int = doDBHelper.loadActive().count()


    fun getMaxComp (): Int {
        var maxComp = 0
        doDBHelper.loadActive().forEach {
            if (it.complexity > maxComp) maxComp = it.complexity
        }
        return maxComp
    }

    fun getMaxChain ():Int {
        var maxChain = 0
        doDBHelper.loadActive().forEach {
            val length = it.chain.target?.length ?: 0
            if (length > maxChain) maxChain = length
        }
        return maxChain
    }

    fun setMaxChain (value: Int) {
        val count = doDBHelper.loadActive().count()
        if (count == 0) return
        val doList = doDBHelper.loadActive()
        doList.forEach { it.chain.target == null}
        doDBHelper.saveList(doList)
        val randomIndex = Random().nextInt(count)
        val doObj = doDBHelper.loadActive()[randomIndex]
        doObj.chain.target = Chain(length = value)
        doDBHelper.save (doObj)
    }

    fun refresh (){
        val doList = doDBHelper.loadAll()
        wpTextView.text = getWillPower().toString()
        countTextView.text = getCount().toString()
        chainTextView.text = getMaxChain().toString()
        maxCompTextView.text = getMaxComp().toString()
    }
}
