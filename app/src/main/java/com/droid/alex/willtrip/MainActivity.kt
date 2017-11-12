package com.droid.alex.willtrip

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.droid.alex.willtrip.extension_func.addFragment
import com.droid.alex.willtrip.ui.CreateDoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(CreateDoFragment(), R.id.container)
    }
}
