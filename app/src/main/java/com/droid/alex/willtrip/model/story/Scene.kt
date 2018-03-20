package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.object_box.IntConverter
import com.droid.alex.willtrip.object_box.SceneDBHelper
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Scene (@Id(assignable = true) var id: Long = 0, val drawableId: Int = 0, val titleTextId: Int = 0, val mainTextId: Int = 0,
             @Convert(converter = IntConverter::class, dbType = String::class) val optionIdArray: ArrayList <Int> = arrayListOf(),
             @Convert(converter = IntConverter::class, dbType = String::class) val obstacleIdArray: ArrayList <Int> = arrayListOf())