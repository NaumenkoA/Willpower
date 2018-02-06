package com.droid.alex.willtrip.model

import android.os.Parcel
import android.os.Parcelable
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class DayPeriod(@Id var id: Long = 0, val type: String, val period: ByteArray) : Parcelable {
    constructor(source: Parcel) : this(
            source.readLong(),
            source.readString(),
            source.createByteArray()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeString(type)
        writeByteArray(period)
    }

    companion object {
        const val DAYS_OF_WEEK = "days_of_week"
        const val REPEAT_EVERY_N_DAYS = "repeat"
        const val TIMES_A_WEEK = "times"

        @JvmField
        val CREATOR: Parcelable.Creator<DayPeriod> = object : Parcelable.Creator<DayPeriod> {
            override fun createFromParcel(source: Parcel): DayPeriod = DayPeriod(source)
            override fun newArray(size: Int): Array<DayPeriod?> = arrayOfNulls(size)
        }
    }

}