package com.droid.alex.willtrip.model

import android.os.Parcel
import android.os.Parcelable
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne
import java.util.*

@Entity
class Do(@Id var id: Long = 0, val name: String = "", val note: String? = null, val isPositive: Boolean = true, val complexity: Int = 0, val startDate: Date = Calendar.getInstance().time, val expireDate: Date? = null) : Parcelable {
    lateinit var dayPeriod: ToOne<DayPeriod>

    constructor(source: Parcel) : this(
            source.readLong(),
            source.readString(),
            source.readString(),
            1 == source.readInt(),
            source.readInt(),
            source.readSerializable() as Date,
            source.readSerializable() as Date?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeString(name)
        writeString(note)
        writeInt((if (isPositive) 1 else 0))
        writeInt(complexity)
        writeSerializable(startDate)
        writeSerializable(expireDate)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Do> = object : Parcelable.Creator<Do> {
            override fun createFromParcel(source: Parcel): Do = Do(source)
            override fun newArray(size: Int): Array<Do?> = arrayOfNulls(size)
        }
    }
}