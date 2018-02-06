package com.droid.alex.willtrip.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class DoManager (@Id var id: Long, val name: String)