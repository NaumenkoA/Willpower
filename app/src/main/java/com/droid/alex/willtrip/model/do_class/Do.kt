package com.droid.alex.willtrip.model.do_class

import android.os.Parcelable
import java.util.*

abstract class Do(val name: String, val note: String?, val isPositive: Boolean = true, val complexity: Int, val startDate:Date, val expireDate: Date?):Parcelable