package com.droid.alex.willtrip.model.story

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Index

@Entity
class Scene (@Id var id: Long = 0, @Index val position: Int, val drawable: String, val fragmentArray: Array <SceneFragment>, val optionArray:Array <Option>, val obstacleArray: Array <Obstacle>)