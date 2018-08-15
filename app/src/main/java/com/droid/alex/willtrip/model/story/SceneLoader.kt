package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.object_box.SceneDBHelper

class SceneLoader () {
    private val dbHelper = SceneDBHelper();

    lateinit var sceneTheme: SceneTheme
    lateinit var currentScene: Scene
    lateinit var obstacleArray: ArrayList <Obstacle>
    lateinit var optionArray: ArrayList <Option>
    private val obstacleLoader = ObstacleLoader()

    fun loadScene (link: Int) {
        obstacleArray = arrayListOf()
        optionArray = arrayListOf()

        if (link == 1) dbHelper.saveStory(Story())

        currentScene = dbHelper.findScene(link)!!
        sceneTheme = dbHelper.findSceneTheme(currentScene.themeLink)!!

        val obstacleIdArray = currentScene.obstacleLinkArray
        obstacleIdArray.forEach { it ->
            val obstacle = obstacleLoader.findObstacle(it)
            obstacleArray.add(obstacle)}

        val optionIdArray = currentScene.optionLinkArray
        optionIdArray.forEach {
            val option = dbHelper.findOption(it)!!
            optionArray.add(option)
        }
    }
}