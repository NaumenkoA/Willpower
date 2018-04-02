package com.droid.alex.willtrip.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.extension_func.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity(), TaleFragment.OnSettingsSelectedListener {
    override fun onSettingsSelected() {
        replaceFragment(SettingsFragment(), R.id.container)
    }

    var currentFragment:Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val newCreateDoFragment = CreateDoFragment()
//        addFragment(newCreateDoFragment, R.id.container, CREATE_DO_FRAGMENT)
//        currentFragment = newCreateDoFragment

        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.getItemId()) {
                R.id.action_all -> addFragment(DoListFragment(), R.id.container, DO_LIST_FRAGMENT)
                R.id.action_today -> replaceFragment(TodayFragment(), R.id.container)
                R.id.action_trip_mode -> replaceFragment(TaleFragment(), R.id.container)
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
}


