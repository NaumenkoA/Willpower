package com.droid.alex.willtrip.object_box

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
class IntValue (@Id var id: Long = 0, @Index val link: Int, val value: Int)