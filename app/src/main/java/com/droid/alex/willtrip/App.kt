package com.droid.alex.willtrip

import android.app.Application
import com.droid.alex.willtrip.model.MyObjectBox
import io.objectbox.BoxStore

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
}

    private lateinit var boxStore: BoxStore

    override fun onCreate() {
        super.onCreate()
        instance = this
        boxStore = MyObjectBox.builder().androidContext(this).build();
    }

    fun getBoxStore (): BoxStore {
        return boxStore
    }
}