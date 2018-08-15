package com.droid.alex.willtrip.object_box

import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.model.core.Chain
import com.droid.alex.willtrip.model.core.Chain_
import com.droid.alex.willtrip.model.core.Do
import java.util.*

class DoDBHelper {

    val doBox = App.instance.getBoxStore().boxFor(Do::class.java)
    val chainBox = App.instance.getBoxStore().boxFor(Chain::class.java)

    fun loadAll (): List <Do> {
        return doBox.all
    }

    fun count (): Long {
        return doBox.count()
    }

    fun loadNotExpired(currentDate: Date = Calendar.getInstance().time): List <Do> {
        return doBox.all.filter {
            (it.expireDate == null || it.expireDate >= currentDate)
        }
    }

    fun loadActive(currentDate: Date = Calendar.getInstance().time): List <Do> {
        return doBox.all.filter {
            (it.startDate <= currentDate && (it.expireDate == null || it.expireDate >= currentDate))
        }
    }

    fun getMaxChain (): Int {
        var maxValue = 0
        loadActive().forEach {
           if (it.chain.target != null && it.chain.target.length > maxValue) maxValue = it.chain.target.length
        }
        return maxValue
    }

    fun getMaxComplexity(): Int {
        var maxComplexity = 0
        loadActive().forEach {
            if (it.complexity > maxComplexity) maxComplexity = it.complexity
        }
        return maxComplexity
    }

    fun save(doObj: Do) {
        doBox.put(doObj)
    }

    fun saveList(doList: List<Do>) {
        doBox.put(doList)
    }

    fun removeAll() {
        doBox.removeAll()
    }
}