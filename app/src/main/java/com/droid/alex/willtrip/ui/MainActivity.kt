package com.droid.alex.willtrip.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.extension_func.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import android.widget.Toast


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
//        val newCreateDoFragment = CreateDoFragment()
//        addFragment(newCreateDoFragment, R.id.container, CREATE_DO_FRAGMENT)
//        currentFragment = newCreateDoFragment

        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.getItemId()) {
                R.id.action_all -> addFragment(DoListFragment(), R.id.container, DO_LIST_FRAGMENT)
                R.id.action_today -> Toast.makeText(this, "Today", Toast.LENGTH_SHORT).show()
                R.id.action_trip_mode -> Toast.makeText(this, "Will trip", Toast.LENGTH_SHORT).show()
            }
            true
        };
        navigation.selectedItemId = R.id.action_all
    }

    companion object {
        val DATE_FRAGMENT = "date_fragment"
        val CREATE_DO_FRAGMENT = "create_do_fragment"
        val DO_LIST_FRAGMENT = "do_list_fragment"
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


