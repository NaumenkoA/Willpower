package com.droid.alex.willtrip.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.extension_func.*
import java.util.*


class MainActivity : AppCompatActivity(), CreateDoFragment.OnDateSelectionListener, DateFragment.OnDateSelectedListener {

    var currentFragment:Fragment? = null


    override fun onDateSelected(date: Date) {
        swapDateFragment(date)
    }

    private fun swapDateFragment(date: Date?) {
        val createDoFragment = supportFragmentManager.findFragmentByTag(CREATE_DO_FRAGMENT) as CreateDoFragment
        val dateFragment = supportFragmentManager.findFragmentByTag(DATE_FRAGMENT)
        createDoFragment.onDateSelected(date)
        removeFragment(dateFragment)
        showFragment(createDoFragment)
        currentFragment = createDoFragment
    }

    override fun onDateSelection() {
        val createDoFragment = supportFragmentManager.findFragmentByTag(CREATE_DO_FRAGMENT)
        hideFragment(createDoFragment)
        val newDateFragment = DateFragment ()
        addFragment(newDateFragment, R.id.container, DATE_FRAGMENT)
        currentFragment = newDateFragment
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newCreateDoFragment = CreateDoFragment()
        addFragment(newCreateDoFragment, R.id.container, CREATE_DO_FRAGMENT)
        currentFragment = newCreateDoFragment
    }

    companion object {
        val DATE_FRAGMENT = "date_fragment"
        val CREATE_DO_FRAGMENT = "create_do_fragment"
    }

    override fun onBackPressed() {
        super.onBackPressed()
        when (currentFragment) {
            is DateFragment -> {
                swapDateFragment(null)
            }
        }
    }
}


