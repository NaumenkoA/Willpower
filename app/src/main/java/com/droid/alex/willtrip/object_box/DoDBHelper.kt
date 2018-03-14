package com.droid.alex.willtrip.object_box

import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.model.core.Do
import java.util.*

class DoDBHelper {

    val doBox = App.instance.getBoxStore().boxFor(Do::class.java)

    fun loadAll (): List <Do> {
        return doBox.all
    }

    fun loadNotExpired(currentDate: Date): List <Do> {
        return doBox.all.filter {
            (it.expireDate == null || it.expireDate >= currentDate)
        }
    }
}