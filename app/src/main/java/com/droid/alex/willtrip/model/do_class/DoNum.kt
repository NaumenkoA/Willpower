package com.droid.alex.willtrip.model.do_class

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class DoNum(name: String, note: String, isPositive: Boolean, complexity: Int, startDate: Date, expireDate: Date?, val numberOfDays: Int) : Do(name, note, isPositive, complexity, startDate, expireDate) {

    constructor(parcel: Parcel) : this(
            TODO("name"),
            TODO("note"),
            TODO("isPositive"),
            TODO("complexity"),
            TODO("startDate"),
            TODO("expireDate"),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
        parcel.writeInt(numberOfDays)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoNum> {
        override fun createFromParcel(parcel: Parcel): DoNum {
            return DoNum(parcel)
        }

        override fun newArray(size: Int): Array<DoNum?> {
            return arrayOfNulls(size)
        }
    }
}