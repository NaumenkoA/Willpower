package com.droid.alex.willtrip.extension_func

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, tag: String){
    supportFragmentManager.inTransaction { add (frameId, fragment, tag)}
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.inTransaction{replace(frameId, fragment, tag)}
}

fun AppCompatActivity.replaceFragmentWithBackstack(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.inTransaction{addToBackStack(null).replace(frameId, fragment, tag)}
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int){
    supportFragmentManager.inTransaction { add (frameId, fragment)}
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction{replace(frameId, fragment)}
}

fun AppCompatActivity.replaceFragmentWithBackstack(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction{addToBackStack(null).replace(frameId, fragment)}
}