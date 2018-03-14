package com.droid.alex.willtrip.model.core

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Chain (@Id var id: Long = 0, val length: Int = 0)