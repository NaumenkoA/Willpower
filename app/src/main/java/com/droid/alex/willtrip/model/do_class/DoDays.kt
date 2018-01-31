package com.droid.alex.willtrip.model.do_class

import android.os.Parcel
import android.os.Parcelable
import java.util.*
import kotlin.collections.ArrayList


class DoDays(name: String, note: String, isPositive: Boolean, complexity: Int, startDate: Date, expireDate: Date?, val numberOfDays: ArrayList <Int>) : Do(name, note, isPositive, complexity, startDate, expireDate) {

    constructor(parcel: Parcel) : this(
            TODO("name"),
            TODO("note"),
            TODO("isPositive"),
            TODO("complexity"),
            TODO("startDate"),
            TODO("expireDate"),
            TODO("numberOfDays")) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoDays> {
        override fun createFromParcel(parcel: Parcel): DoDays {
            return DoDays(parcel)
        }

        override fun newArray(size: Int): Array<DoDays?> {
            return arrayOfNulls(size)
        }
    }
}
