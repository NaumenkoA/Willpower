package com.droid.alex.willtrip

import android.app.Application
import com.droid.alex.willtrip.model.DoManager
import com.droid.alex.willtrip.model.MyObjectBox
import io.objectbox.BoxStore

class App : Application() {

    private lateinit var boxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        boxStore = MyObjectBox.builder().androidContext(this).build();
    }

    fun getBoxStore (): BoxStore {
        return boxStore
    }
}