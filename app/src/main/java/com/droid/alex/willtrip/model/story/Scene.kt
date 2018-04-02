package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.object_box.IntConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
class Scene (@Id var id: Long = 0, @Index val link: Int = 0, val themeLink: Int = 0, val mainTextId: Int = 0,
             @Convert(converter = IntConverter::class, dbType = String::class) val optionLinkArray: ArrayList <Int> = arrayListOf(),
             @Convert(converter = IntConverter::class, dbType = String::class) val obstacleLinkArray: ArrayList <Int> = arrayListOf())