package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.object_box.SceneDBHelper

class SceneLoader () {
    private val dbHelper = SceneDBHelper();

    lateinit var currentScene: Scene
    lateinit var obstacleArray: ArrayList <Obstacle>
    lateinit var optionArray: ArrayList <Option>

    init {
        if (dbHelper.sceneBox.count() < 1) dbHelper.saveStory(Story())
        }

    fun loadScene (id: Long) {
        obstacleArray = arrayListOf()
        optionArray = arrayListOf()

        currentScene = dbHelper.findScene(id)

        val obstacleIdArray = currentScene.obstacleIdArray
        obstacleIdArray.forEach { it ->
            val obstacle = dbHelper.findObstacle(it.toLong())
            obstacleArray.add(obstacle)}

        val optionIdArray = currentScene.optionIdArray
        optionIdArray.forEach {
            val option = dbHelper.findOption(it.toLong())
            optionArray.add(option)
        }
    }
}