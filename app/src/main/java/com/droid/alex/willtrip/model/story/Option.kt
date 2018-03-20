package com.droid.alex.willtrip.model.story

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Transient

@Entity
class Option (@Id(assignable = true) var id: Long, val nextSceneId: Int, val textId: Int, @Transient var isEnabled: Boolean = true)
