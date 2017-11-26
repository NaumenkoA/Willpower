package com.droid.alex.willtrip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.droid.alex.willtrip.extension_func.addFragment
import com.droid.alex.willtrip.extension_func.replaceFragment
import com.droid.alex.willtrip.extension_func.replaceFragmentWithBackstack
import com.droid.alex.willtrip.ui.CreateDoFragment
import com.droid.alex.willtrip.ui.DateFragment
import java.util.*


class MainActivity : AppCompatActivity(), CreateDoFragment.OnDateSelectionListener, DateFragment.OnDateSelectedListener {


    override fun onDateSelected(date: Date) {
        var fragment = supportFragmentManager.findFragmentByTag(CREATE_DO_FRAGMENT) as CreateDoFragment
        fragment.expireDate = date
        replaceFragment(fragment, R.id.container)

    }

    override fun onDateSelection() {
        replaceFragmentWithBackstack(DateFragment (), R.id.container, DATE_FRAGMENT)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(CreateDoFragment(), R.id.container, CREATE_DO_FRAGMENT)
    }

    companion object {
        val DATE_FRAGMENT = "date_fragment"
        val CREATE_DO_FRAGMENT = "create_do_fragment"
    }
}


